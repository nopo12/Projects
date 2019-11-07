import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindWords implements IFindWords {

    /**
     * Constructor
     */
    public FindWords(){

    }

    @Override
    public List<String> process(String data) {
        List<String> splitWords = new ArrayList<>();
        String[] datas = data.split("\n");
        for (String line : datas) {
            splitWords.addAll(Arrays.asList(line.split(" ")));
        }
        return splitWords;
    }

}
