import java.util.List;

public interface INonAlphabeticFilter {
    /**
     * Strip out all non-alphabetic characters.
     * Eliminate any “words” that are just white space.
     * @param data
     * @return
     */
    List<String> process(List <String> data);
}
