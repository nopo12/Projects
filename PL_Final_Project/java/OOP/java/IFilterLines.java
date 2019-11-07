import java.util.List;
public interface IFilterLines {
    /**
     * Filters-Lines filter out lines that don’t meet grep search criteria
     */
    public String process(String data);
}
