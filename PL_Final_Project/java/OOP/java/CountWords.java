import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class CountWords implements ICountWords {

    /**
     * Constructor
     */
    public CountWords(){

    }

    @Override
    public Map<String, Integer> process(List<String> data) {
        Map<String,Integer> mapResult  = new HashMap<>();
        for (String word : data) {
            if(!mapResult.containsKey(word)){//if it is NOT in map
                mapResult.put(word,1);//add it to map
            }else{//is already in map
                mapResult.put(word, mapResult.get(word) + 1);//update frequency
            }
        }
        return mapResult;
    }
}
