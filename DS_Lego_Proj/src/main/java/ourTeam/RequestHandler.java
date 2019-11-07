package ourTeam;

import java.util.*;
import java.util.concurrent.*;

import java.io.PrintWriter;


public class RequestHandler implements Runnable {

    private Request request;
    private DBManager DB;

    private ThreadPoolExecutor partConstructorThreadPool;
    private PrintWriter toClient;
    private DBLockHandler DBLocks;
    private final int incrementPartsBy = 30;



    public static void main(String args[]){
        Request testReq = new Request();
        testReq.addSet(1, 5);
        testReq.addSet(2,3);
        testReq.addSet(3,2);
        DBManager testDB = new DBManagerImpl();
        ThreadPoolExecutor testPool = new ThreadPoolExecutor(100, 100, 1, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.DiscardPolicy());
        testPool.prestartAllCoreThreads();
        DBLockHandler testLocks = new DBLockHandler();
        PrintWriter testPrint = null;
        RequestHandler testHandler = new RequestHandler(testReq,testDB,testPool,testLocks,testPrint);
        testHandler.run();

    }
    public RequestHandler(Request request, DBManager DB, ThreadPoolExecutor threadPool, DBLockHandler locks, PrintWriter toClient) {
        this.request = request;
        this.DB = DB;
        this.toClient = toClient;
        partConstructorThreadPool = threadPool;
        DBLocks = locks;
    }

    @Override
    public void run() {
        HashMap<Integer, Integer> requestedSetsMap = request.getSets(); //setNames/quantities desired
        Set<Integer> requestedSetNames = requestedSetsMap.keySet(); // set of names of sets wanted by client
        HashMap<Integer, Integer> setsNotAvailable = new HashMap<>(); // list to contain sets that are not available
        HashMap<Integer, Integer>  availableSets = new HashMap<Integer, Integer>();
            
        /*
         * figure out which sets we do not have in stock
         */
        DBLocks.writeLockAllSets();
        for (Integer set : requestedSetNames) { //check if sets are in stock


            int amountNeeded = requestedSetsMap.get(set);
            int amountAvailable = DB.getSetCount(set);
            if (amountNeeded > amountAvailable) {
                setsNotAvailable.put(set, amountNeeded - amountAvailable);
                if(amountAvailable > 0)
                    availableSets.put(set, amountAvailable);
            }
            else
                availableSets.put(set, amountNeeded);
        }

        reserveSets(availableSets);//decrement the available sets in the DB so that they can be reserved for this customer and unlocked for other thread's usage.


        DBLocks.writeUnlockAllSets();


        /*
         * manufacture those sets so that we can complete the order
         */


        if (!setsNotAvailable.isEmpty()) { //if some sets are not in stock, must determine which parts are needed

            alertClientBackordered();

            int actualPartQuantity, neededPartQuantity, differenceNeeded = 0; // placeholders for later
            /*
             * figure out how much of which parts are needed in total to complete the order
             */
            Map<String, SetPartAmountTuple> neededParts = new HashMap<String, SetPartAmountTuple>();//part needed and <set, amountOfPArtNeeded> tuple

            DBLocks.readLockAllParts();

            for (Integer set : setsNotAvailable.keySet()) { //for every set
                Set<String> setParts = DB.getParts(set);//get a set of its parts and put that set in a map under the set's name
                for (String part : setParts) { //for every part of this set
                    if (!neededParts.containsKey(part)) {
                        neededParts.put(part, new SetPartAmountTuple(set, setsNotAvailable.get(set))); //need one copy of the part per copy of the set
                    } else {
                        neededParts.put(part, new SetPartAmountTuple(set, (setsNotAvailable.get(set) + neededParts.get(part).amount)));
                    }
                }
            }

            DBLocks.readUnlockAllParts();
            DBLocks.writeLockAllParts();//will actually be decrementing parts now

            /*
             * Figure out how much of which parts we need to manufacture
             */
            Map<String, SetPartAmountTuple> partsToManufacture = new HashMap<String, SetPartAmountTuple>();
            Map<String, SetPartAmountTuple> partsToReserve = new HashMap<String, SetPartAmountTuple>();
            SetPartAmountTuple currentTuple;
            for (String part : neededParts.keySet()) {
                currentTuple = neededParts.get(part);
                actualPartQuantity = DB.getPartCount(currentTuple.set, part);
                neededPartQuantity = currentTuple.amount;

                if (actualPartQuantity < neededPartQuantity) {
                    partsToManufacture.put(part, new SetPartAmountTuple(currentTuple.set, (neededPartQuantity - actualPartQuantity)));
                    if(actualPartQuantity > 0)
                        partsToReserve.put(part, new SetPartAmountTuple(currentTuple.set, actualPartQuantity));
                }
                else
                    partsToReserve.put(part, new SetPartAmountTuple(currentTuple.set, (neededPartQuantity)));
            }

            reserveParts(partsToReserve);
            DBLocks.writeUnlockAllParts();

            /*
             * manufacture those parts
             */
            if (!partsToManufacture.isEmpty()) { //the map of needed parts is not empty, we must need to order some parts
                manufactureParts(partsToManufacture); //"manufacture" the parts (start thread with 100 millisecond timer for each parts, wait for them to finish


                DBLocks.writeLockAllParts();


                incrementParts(partsToManufacture); //increment the amount of parts in the actual database
                decrementParts(partsToManufacture);


                DBLocks.writeUnlockAllParts();
            }

            //else, parts in stock
            /*
             * turn the parts into sets
             */
            DBLocks.writeLockAllSets();


            manufactureSets(setsNotAvailable);
            shipSets(setsNotAvailable);


            DBLocks.writeUnlockAllSets();
        }



        informClientSuccess();

    }

    private void alertClientBackordered() {
        if (toClient == null) {
            System.out.println("Your order (" + request.getName() + ") is backordered. Will ship soon!");
            return;
        }
        toClient.println("Your order (" + request.getName() + ") is backordered. Will ship soon!");
    }


    class SetPartAmountTuple{
        int set,amount;

        SetPartAmountTuple(int set, int amount){
            this.set = set;
            this.amount = amount;
        }
    }

    /*
     * ***** METHODS DEALING WITH DATABASE STUFF *****
     */

    private void incrementParts(Map<String, SetPartAmountTuple> parts) {
        Set<String> partNames = parts.keySet();
        for(String part : partNames){
            int increment = incrementPartsBy * roundUp(parts.get(part).amount, incrementPartsBy);
            DB.incrementPart(parts.get(part).set, part, increment);
        }
    }

    /**
     * reserves parts to be used in a manufacture process of sets later on. Since reserving here is the same as decrementing, just call decrementParts
     * @param partsToReserve parts to decrement in DB
     */
    private void reserveParts(Map<String,SetPartAmountTuple> partsToReserve) {
        decrementParts(partsToReserve);
    }

    private void decrementParts(Map<String, SetPartAmountTuple> parts) {
        Set<String> partNames = parts.keySet();
        SetPartAmountTuple tuple;
        for(String part : partNames){
            tuple = parts.get(part);
            DB.decrementPart(tuple.set, part, tuple.amount * 2);
        }
    }

    private void manufactureSets(HashMap<Integer, Integer> sets) {
        Set<Integer> setNames = sets.keySet();
        for(Integer set : setNames){
            DB.incrementSet(set, sets.get(set) + 1);
        }
    }

    private void decrementPartsOfSet(int set, int amount) {
        Set<String> parts = DB.getParts(set);
        for(String part : parts){
            DB.decrementPart(set, part, amount);
        }
    }

    /**
     * reserves sets from DB for future shipping. Since for our purposes shipping and decrementing the DB are the same thing, just calls shipSets
     * @param sets hashmap mapping set_number to amount_to_reserve
     */
    private void reserveSets(HashMap<Integer,Integer> sets) {
        shipSets(sets);
    }

    private void shipSets(HashMap<Integer, Integer> sets){
        Set<Integer> requestedSets = sets.keySet();
        for(Integer set : requestedSets){
            DB.decrementSet(set, sets.get(set));

        }
    }

    /*
     * ***** METHODS DEALING WITH OTHER PARTS OF THE LOGIC *****
     */

    private void manufactureParts(Map<String, SetPartAmountTuple> neededParts) {
        List<Callable<Object>> partRunables = new ArrayList<Callable<Object>>();
        int amount = 0;
        for(SetPartAmountTuple tuple : neededParts.values()){
            amount = tuple.amount;
            partRunables.add(Executors.callable(new partConstructor(roundUp(amount, incrementPartsBy) * 100)));
        }
        try {
            partConstructorThreadPool.invokeAll(partRunables);
        } catch (InterruptedException e) {
            e.printStackTrace(); //TODO
        }
    }

    class partConstructor implements Runnable {
    	private int time = 100;

    	public partConstructor(int time) {
    		this.time = time;
    	}

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace(); //TODO
            }
        }
    }


    private void informClientSuccess(){
        if (toClient == null) {
            System.out.println("Your order (" + request.getName() + ") has shipped.");
            return;
        }
        toClient.println("Your order (" + request.getName() + ") has shipped.");
    }

    //got this from here: https://stackoverflow.com/questions/7446710/how-to-round-up-integer-division-and-have-int-result-in-java
    private int roundUp(int num, int divisor) {
        return (num + divisor - 1) / divisor;
    }
}
