import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ConvertCase implements IConvertCase {


    /**
     * Constructor
     */
    public ConvertCase(){

    }

    @Override
    public String process(String data){
        return data.toLowerCase();
    }


}
