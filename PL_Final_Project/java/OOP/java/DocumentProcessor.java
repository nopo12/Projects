import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DocumentProcessor {

    private String data;
    private List<String> words;
    private Map<String, Integer> mapR;
    private String filterBy;


    private DocumentProcessor() {
        //empty
    }

    public String processGrep(String data){
        return this.data;
    }

    public Map<String,Integer> processGrepWC(String data){
        return mapR;
    }

    public static class Builder{
        private String data;
        private List<String> words;
        private Map<String, Integer> mapR;
        private String filterBy;

        public Builder(String data){
            this.data = data;
        }

        public Builder setLineFilter(IFilterLines filterLines) {
            this.data = filterLines.process(data);
            return this;
        }

        public Builder setConvertCase(IConvertCase convertCase) {
            this.data = convertCase.process(data);
            return this;
        }

        public Builder setFindWords(IFindWords findWords) {
            this.words = findWords.process(data);
            return this;
        }

        public Builder setNonAlphaFilter(INonAlphabeticFilter nonAlphaFilter) {
            this.words = nonAlphaFilter.process(words);
            return this;
        }

        public Builder setCountWords(ICountWords countWords) {
            this.mapR = countWords.process(words);
            return this;
        }

        public DocumentProcessor build(){
            DocumentProcessor dp = new DocumentProcessor();
            dp.data = this.data;
            dp.mapR = this.mapR;
            dp.filterBy = this.filterBy;
            dp.words = this.words;
            return dp;
        }

    }

}