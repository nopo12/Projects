/* Input: 
1) a string containing the text to search for
, can be comprised of a single word, or of multiple words surrounded by double quote marks  
2) a path to the file to search 
Output : every line in the file in which the given string appears.*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FilterLines implements IFilterLines {

    private String data;
    private String filterBy;
    /**
     * Constructor
     */
    public FilterLines(String data, String filterBy){
        this.data = data;
        this.filterBy = filterBy;
    }

    @Override
    public String process(String data){
        this.data = data;
        List<String> filtered = new ArrayList<>();
        String[] lines = data.split("\n");
        for (String line : lines) {
            if(line.contains(filterBy)){
                filtered.add(line);
            }
        }
        return String.join("\n", filtered);
    }
}
