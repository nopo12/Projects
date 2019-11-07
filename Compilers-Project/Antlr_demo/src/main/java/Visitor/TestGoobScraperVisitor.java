package Visitor;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestGoobScraperVisitor extends GoobScraperBaseVisitor<String> {
    private static Map<String,Variable> varMem = new HashMap<>();
    private static Variable lastVar;


    @Override
    public String visitUpdateStatment(GoobScraperParser.UpdateStatmentContext ctx) {
        // the metadata of each file will be stored in a separate file with a MD.txt
        String fileName;
        if (ctx.word() == null ) {
            fileName = lastVar.getFileName();
        }
        else if (Files.exists(Paths.get(ctx.word().getText().replace("\"", "")))) {
            fileName = ctx.word().getText().replace("\"", "");
        }
        else {
            fileName = getVar(ctx.word()).getFileName();
        }
        String timeStr = ctx.time().getText();
        System.out.println(timeStr);
        String updateType = visit(ctx.getChild(1));
        File file;
        try {
            file = getFile(getMDFileName(fileName));
            updateMetaDataFile(updateType, timeStr, file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        System.out.println("End of update");
        return null;
    }

    @Override
    public String visitUpdateAppend(GoobScraperParser.UpdateAppendContext ctx) { return ctx.getText(); }


    @Override
    public String visitUpdateNew(GoobScraperParser.UpdateNewContext ctx) { return ctx.getText(); }


    private void updateMetaDataFile(String updateType, String updateTime, File file) throws IOException {
        System.out.println("updateMetaDataFile; file: " + file.getName());
        // From https://stackoverflow.com/questions/20753600/creating-writing-and-editing-same-text-file-in-java
        String line;StringBuilder content = new StringBuilder();
        System.out.println(file.getName());
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String theLine = "update: " + updateType + "; " + updateTime + "\n";
        while ((line = br.readLine()) != null) {
            if (line.contains("update: "))  content.append("\n").append(theLine);
            else content.append(line).append("\n");
        }
        br.close();
        if (!content.toString().contains(theLine)) content.append(theLine);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content.toString());
        bw.close();
    }

    private void insertVarMetaDataFile(Variable var, File file) throws IOException {
        System.out.println("insertVarMetaDataFile: updateAppendType; file: " + file.getName());
        // From https://stackoverflow.com/questions/20753600/creating-writing-and-editing-same-text-file-in-java
        String line;
        boolean hadURL = false, hadSteps = false, readingSteps = false, hadHash = false;
        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String theLine = "URL: " + var.getURL() + ";\n";
        while ((line = br.readLine()) != null) {
            if (readingSteps && !(line.startsWith("End Steps"))) continue;
            readingSteps = false;
            if (line.equals("") || line.equals("End Steps")) continue;
            if (line.startsWith("URL: ")) {
                if(hadURL) continue;
                content.append("\n").append(theLine).append("\n");
                hadURL = true;
            }
            else if (line.startsWith("Steps: ")) {
                if (hadSteps) continue;
                content.append("\n").append("Steps: \n");
                readingSteps = true;
                hadSteps = true;
                for (String step : var.getSteps()) {
                    content.append(step).append("\n");
                }
                content.append("End Steps").append("\n\n");
            }
            else if (line.startsWith("hash:")) {
                if (hadHash) continue;
                content.append("\n").append("hash: ").append(var.getText().hashCode()).append("\n");
                hadHash = true;
            }

            else content.append(line).append("\n");
        }
        if (!hadURL) content.append("\n").append(theLine).append("\n");
        if (!hadSteps) {
            content.append("Steps: \n");
            for (String step : var.getSteps()) {
                content.append(step).append("\n");
            }
            content.append("End Steps").append("\n\n");
        }
        if (!hadHash) content.append("\n").append("hash: ").append(var.getText().hashCode()).append("\n");
        br.close();
        if (!content.toString().contains(theLine)) content.append(theLine);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content.toString());
        bw.close();
    }


    //ex. "/get table VAR" or "/get table";
    @Override
    public String visitGetTable(GoobScraperParser.GetTableContext ctx){
        String html;
        Variable var;
        if ((var = getVar(ctx.word())) == null) {
            html = lastVar.getText();
        }
        else {
            html = var.getText();
        }
        StringBuilder contentTxt = new StringBuilder();
        try {
              // String urlTest = "https://www.w3schools.com/html/html_tables.asp";
             // String url = ctx.getChild(1).getText().replace("\"", "");
            // Document doc = Jsoup.connect(urlTest).get();
            Document doc = Jsoup.parse(html);
            Elements tables = doc.getElementsByTag("table");

            for(Element table : tables){
                Elements rows = table.select("tr");
                Elements ths = rows.select("th");

                String thstr = "";
                for (Element th : ths) {
                    thstr += th.text() + ",";
                }
                System.out.print(thstr);
                contentTxt.append(thstr);

                for (Element row : rows) {
                    Elements tds = row.select("td");
                    for (Element td : tds) {
                        System.out.print(td.text() + ",");  // --> This will print them individually
                        contentTxt.append(td.text()).append(",");
                    }
                    System.out.println(); //next row
                    contentTxt.append("\n");
                }
                //separates tables when being displayed
                System.out.println("---------------------------------------------------------------");
                contentTxt.append("-:-").append("\n");
            }
            var.setText(contentTxt.toString());// set content to var
        } catch (Exception e) {
            e.printStackTrace();
        }
        var.addStep("/get table");
        lastVar = var;
        return contentTxt.toString();
    }

    // ex. /get <any tag> <url>
    @Override
    public String visitRegularGet(GoobScraperParser.RegularGetContext ctx) {
        StringBuilder toReturn = new StringBuilder();
        try {
            String url = ctx.getChild(1).getText();
            String searchWord = ctx.getChild(0).getText();
            // "https://www.simplyhired.com/search?q=software+engineer+internship&l=&job=n7bNHcC6SCTRXJm6oS_OARzDwQVbKXWHX21n6YVrcdjMNKBO1E1QwQ"
            Document doc = Jsoup.connect(url).get();
            Elements searchWords = doc.getElementsByTag("a");
            List<Element> foundElements = new ArrayList<>();
            for(Element word : searchWords){
                String txt = word.toString();
                if(txt.contains(searchWord)){
                    foundElements.add(word);
                }
            }
            //String bob  = elements.toString();
            System.out.println();
            for (Element word : foundElements) {
                System.out.println(word);
                toReturn.append(word).append(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toReturn.toString();
    }

    @Override
    public String visitGetURL(GoobScraperParser.GetURLContext ctx) {
        //https://en.wikipedia.org/wiki/Oversampling_and_undersampling_in_data_analysis
        URLConnection connection = null;
        try {
            String url = ctx.word().getText().replace("\"", "");
            // String url = ctx.word().getText().replace("\"", "");
            connection = new URL(url).openConnection();
            InputStream response = connection.getInputStream();
            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            System.out.println(responseBody);
            lastVar = Variable.variableFactory(url, responseBody);
            varMem.put(lastVar.getName(), lastVar);
            lastVar.addStep("/get url " + ctx.word().getText());
            System.out.println("Visitor.Variable reference name: " + lastVar.getName());
            return lastVar.getName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String visitExtractStatment(GoobScraperParser.ExtractStatmentContext ctx) {
        String file = "";
        Variable var = lastVar;
        System.out.println("visitExtractStatment; lastVar: " + lastVar.getName());
        int wordNum = ctx.word().size();
        if(wordNum == 1){
            file = ctx.getChild(2).getText();
        }else if(wordNum == 2){
            var = varMem.get(ctx.getChild(2).getText());
            if (var == null) var = lastVar;
            file = ctx.getChild(3).getText();
        }

        try {
            FileWriter writer = null;
            String typeUpdate = visit(ctx.getChild(1));
            if (typeUpdate.equals("new"))
                writer = new FileWriter(file.replace("\"",""),false);
            else if (typeUpdate.equals("append"))
                writer = new FileWriter(file.replace("\"",""),true);
            else
                throw new RuntimeException();
            //test example:
            //writer.append("ID");writer.append(',');writer.append("name");writer.append('\n');
            assert var != null;
            String htmlTxt = var.getText();
            String[] tables = htmlTxt.split("-:-");
            for (String table : tables) {
                if(table.length() > 1){
                    table = table.substring(0, table.length() -2);//remove the ',' at the end so table ends
                    writer.append(table);
                }
            }
            writer.flush();
            writer.close();
            /*EX:
                Company,Contact,Country,
                Alfreds Futterkiste,Maria Anders,Germany,
                Centro comercial Moctezuma,Francisco Chang,Mexico,
                Ernst Handel,Roland Mendel,Austria,
                Island Trading,Helen Bennett,UK,
                Laughing Bacchus Winecellars,Yoshi Tannamuri,Canada,
                Magazzini Alimentari Riuniti,Giovanni Rovelli,Italy,
                ---------------------------------------------------------------
                Tag,Description,
                <table>,Defines a table,
                <th>,Defines a header cell in a table,
                <tr>,Defines a row in a table,
                <td>,Defines a cell in a table,
                <caption>,Defines a table caption,
                <colgroup>,Specifies a group of one or more columns in a table for formatting,
                <col>,Specifies column properties for each column within a <colgroup> element,
                <thead>,Groups the header content in a table,
                <tbody>,Groups the body content in a table,
                <tfoot>,Groups the footer content in a table,
                ---------------------------------------------------------------
             */


            if (var != null) {
                var.addStep("/extract new \"" + file.replace("\"","") + "\"");
                insertVarMetaDataFile(varMem.get(var.getName()), getFile(getMDFileName(file.replace("\"",""))));
                var.setFileName(file);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Extracts the data to a new file creating the file in process
     * ex. /extract new (variable)? file.extension;/r -> <EOF> -> <ctrl-D>
     * @param ctx
     * @return
     */
    @Override
    public String visitExtractNew(GoobScraperParser.ExtractNewContext ctx) {
        return "new";
    }

    @Override
    public String visitExtractAppend(GoobScraperParser.ExtractAppendContext ctx) {
        return "append";
    }

    @Override public String visitAlertStatment(GoobScraperParser.AlertStatmentContext ctx) {
        System.out.println("Beginning of alert");
        try {
            File mdFile = getFile(getMDFileName(visit(ctx.getChild(1))));
            BufferedReader br = new BufferedReader(new FileReader(mdFile));
            String text;
            StringBuilder strBuild = new StringBuilder();
            while ((text = br.readLine()) != null) {
                if (!text.startsWith("alert")) strBuild.append(text).append("\n");
            }
            strBuild.append("\n").append("alert: true").append("\n");
            FileWriter writer = new FileWriter(mdFile,false);
            writer.write(strBuild.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        lastVar.setAlert(true);
        System.out.println("End of alert");
        return "ALERT: TRUE";
    }


    @Override public String visitAlertWord(GoobScraperParser.AlertWordContext ctx) {
        Variable var = varMem.get(visit(ctx.getChild(1)));
        if (var != null) {
            lastVar = var;
            return var.getFileName();
        }
        else {
            String fileName = ctx.getChild(1).getText();
            return fileName;
        }

    }

    @Override public String visitAlertEmpty(GoobScraperParser.AlertEmptyContext ctx) {
        Variable var = lastVar;
        if (var != null)
            return var.getFileName();
        else
            throw new RuntimeException();
    }


    @Override
    public String visitQuitStatment(GoobScraperParser.QuitStatmentContext ctx){
        System.out.println("Quitting");
        System.exit(0);
        return "Quit";
    }

    private Variable getVar(GoobScraperParser.WordContext ctxWord) {
        if (ctxWord != null){
            if (varMem.get(ctxWord.getText()) != null)
                return varMem.get(ctxWord.getText());
        }
        if (lastVar == null)
            throw new RuntimeException();
        return lastVar;
    }

    private static String getMDFileName(String fileName) {

        String[] fileSplit = fileName.split("\\.");
        fileName = fileSplit[0];
        return fileName + "_MD.txt";
    }

    private File getFile(String fileName) throws IOException {
        File file = new File(fileName.replace("\"", ""));
        if (!file.exists()) { file.createNewFile(); }
        if (!file.canRead() || !file.canWrite()) {
            file.delete();
            file.createNewFile();
        }
        return file;
    }

    public static void main(String[] args){
        System.out.println("Begin");
        boolean cmd = false;
        if (cmd)
            readFromCMD();
        else {
            File dir = new File(".");
            File[] files = dir.listFiles();
            for (File file : files) {
             //   System.out.println(file.getName());
            }
            readFromFile("testInput.txt");
        }

        System.out.println("Finished");
    }

    private static void readFromFile(String fileName) {
        File file = new File(fileName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(sc.hasNextLine()) {
            parseAndRunLine(sc.nextLine());
        }
    }

    private static void readFromCMD() {
        while (true) {
            System.out.print("~$: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputLine = null;
            try {
                inputLine = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            parseAndRunLine(inputLine);
        }
    }

    public static void parseAndRunLine(String inputLine) {
      //  System.out.println("entered parseAndRunLine");
        CharStream input = CharStreams.fromString(inputLine);


        GoobScraperLexer lexer = new GoobScraperLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        GoobScraperParser parser = new GoobScraperParser(commonTokenStream);
        ParseTree tree = parser.program();  // The error: "line 1:25 token recognition error at: '.'" has been traced to here
        TestGoobScraperVisitor testGoobScraperVisitor = new TestGoobScraperVisitor();
        testGoobScraperVisitor.visit(tree);

    }

}
