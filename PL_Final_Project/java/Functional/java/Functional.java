/* Input:
1) a string containing the text to search for
, can be comprised of a single word, or of multiple words surrounded by double quote marks
2) a path to the file to search
Output : every line in the file in which the given string appears.

Filter-Lines: filter out lines that don’t meet grep search criteria */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Functional{
    /**
     * Constructor
     */
    private Functional(){
        //empty
    }

    /**
     * Main Method
     * @param argv
     */
    public static void main(String[] argv) {
        final int argc = argv.length;
        Functional functional = new Functional();
        //grep word(s) silly.txt
        if(argc > 2 && argv[0].equals("grep") && !argv[argc - 2].equals("|")){
            System.out.println("Running grep");
            String search_str = String.join(" ",Arrays.copyOfRange(argv, 1, argc - 1)).replace("\"", "");
            List<String> data = functional.readFile(argv[argc - 1]);
            String grep_result = functional.grep(data,search_str);
            System.out.println(grep_result);
        }
        else if(argc > 1 && argv[0].equals("wc")){//wc silly.txt
            System.out.println("running wc");
            List<String> data = functional.readFile(argv[argc - 1]);
            Map<String,Integer> result_wc = functional.wc(data);
            result_wc.forEach((k,v)-> System.out.println(k + " " + v));
        }else{//grep this silly.txt | wc
            System.out.println("Running grep_wc");
            String search_str = String.join(" ",Arrays.copyOfRange(argv, 1, argc - 3));
            List<String> data = functional.readFile(argv[argc - 3]);
            Map<String,Integer> result_grep_wc = functional.grepWC(data,search_str);
            result_grep_wc.forEach((k,v)-> System.out.println(k + " " + v));
        }
    }

    /**
     * Filter-Lines: filter out lines that don’t meet grep search criteria
     * @param data
     * @param searchStr
     * @return
     */
    private String grep(List<String> data,String searchStr){
        List<String> result = data.stream().filter(line -> line.contains(searchStr)).collect(Collectors.toList());
        return String.join("\n", result);
    }

    private Map<String,Integer> wc(List<String> data){
        //2. Convert-Case: put everything in lowercase
        Map<String,Integer> result = data.stream().map(String::toLowerCase).flatMap(line-> {
            //3. Find-Words: split the text into individual words.
            return Arrays.stream(line.split(" "));
            //4. Non-Alphabetic-Filter: strip out all non-alphabetic characters.
            //Eliminate any “words” that are just white space.
        }).map(word-> {
            return word.replaceAll("[^a-zA-Z0-9]", "");
        }).filter(word ->{
            return !word.equals("");
            //5.Count-Words: produce a set of unique words and the number of times they each appear.
        }).map(word -> new AbstractMap.SimpleEntry<>(word, 1))//creates tuples and adds up all the values
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey,//and collects them into one map.
                        AbstractMap.SimpleEntry::getValue, (v1, v2) -> v1 + v2));
        return result;
    }

    private Map<String,Integer> grepWC(List<String> data,String searchStr){
        //1.Filter Lines
        Map<String,Integer> result = Arrays.stream(grep(data, searchStr).split("\n")
                //2. Convert-Case: put everything in lowercase
        ).map(String::toLowerCase).flatMap(line-> {
            //3. Find-Words: split the text into individual words.
            return Arrays.stream(line.split(" "));
            //4. Non-Alphabetic-Filter: strip out all non-alphabetic characters.
            //Eliminate any “words” that are just white space.
        }).map(word-> {
            return word.replaceAll("[^a-zA-Z0-9]", "");
        }).filter(word ->{
            return !word.equals("");
            //5.Count-Words: produce a set of unique words and the number of times they each appear.
        }).map(word -> new AbstractMap.SimpleEntry<>(word, 1))//creates tuples and adds up all the values
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey,//and collects them into one map.
                        AbstractMap.SimpleEntry::getValue, (v1, v2) -> v1 + v2));
        return result;
    }

    private List<String> readFile(String pathname){
        List<String> data = new ArrayList<>();
        try {
            File f = new File(pathname);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                data.add(readLine);
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
