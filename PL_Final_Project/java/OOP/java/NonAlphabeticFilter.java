import java.util.ArrayList;
import java.util.List;

public class NonAlphabeticFilter implements INonAlphabeticFilter {

    /**
     * Constructor
     */
    public NonAlphabeticFilter(){

    }

    @Override
    public List<String> process(List<String> data) {
        List<String> alphaOnly = new ArrayList<>();
        for (String word: data) {
            String newWord = word.replaceAll("[^a-zA-Z0-9]", "");
            if(!newWord.equals("")){
                alphaOnly.add(newWord);
            }
        }
        return alphaOnly;
    }
}
