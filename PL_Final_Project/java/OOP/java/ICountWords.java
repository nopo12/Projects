import java.util.Map;
import java.util.List;
import java.util.HashMap;

public interface ICountWords {
    /**
     * Produce a set of unique words and the number of times they each appear.
     * @param data
     * @return
     */
    Map<String,Integer> process(List<String> data);

}
