import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MyMain {


    private String readFile(String pathname){
        StringBuilder data = new StringBuilder();
        try {
            File f = new File(pathname);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                data.append(readLine).append("\n");
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    public static void main(String[] argv) {
        final int argc = argv.length;
        MyMain myMain = new MyMain();
        //grep word(s) silly.txt
        if(argc > 2 && argv[0].equals("grep") && !argv[argc - 2].equals("|")){
            System.out.println("Running grep");
            String data = myMain.readFile(argv[argc - 1]);
            String search_str = String.join(" ",Arrays.copyOfRange(argv, 1, argc - 1)).replace("\"", "");

            IFilterLines fl = new FilterLines(data,search_str);
            DocumentProcessor doc = new DocumentProcessor.Builder(data).setLineFilter(fl).build();
            System.out.println(doc.processGrep(data));

        }
        else if(argc > 1 && argv[0].equals("wc")){//wc silly.txt
            System.out.println("running wc");
            String data = myMain.readFile(argv[argc - 1]);
            String search_str = String.join(" ",Arrays.copyOfRange(argv, 1, argc - 1)).replace("\"", "");
            IConvertCase convertCase = new ConvertCase();
            IFindWords findWords = new FindWords();
            INonAlphabeticFilter nonAlphaFilter = new NonAlphabeticFilter();
            ICountWords countWords = new CountWords();

            DocumentProcessor doc = new DocumentProcessor.Builder(data).setConvertCase(convertCase)
                    .setFindWords(findWords).setNonAlphaFilter(nonAlphaFilter).setCountWords(countWords).build();

            doc.processGrepWC(data).forEach((k,v)-> System.out.println(k + " " + v));
        }else{//grep this silly.txt | wc
            System.out.println("Running grep_wc");
            String data = myMain.readFile(argv[argc - 3]);
            String search_str = String.join(" ",Arrays.copyOfRange(argv, 1, argc - 3)).replace("\"", "");
            IFilterLines fl = new FilterLines(data,search_str);
            IConvertCase convertCase = new ConvertCase();
            IFindWords findWords = new FindWords();
            INonAlphabeticFilter nonAlphaFilter = new NonAlphabeticFilter();
            ICountWords countWords = new CountWords();

            DocumentProcessor doc = new DocumentProcessor.Builder(data).setLineFilter(fl).setConvertCase(convertCase)
                    .setFindWords(findWords).setNonAlphaFilter(nonAlphaFilter).setCountWords(countWords).build();

            doc.processGrepWC(data).forEach((k,v)-> System.out.println(k + " " + v));
        }
    }

}
