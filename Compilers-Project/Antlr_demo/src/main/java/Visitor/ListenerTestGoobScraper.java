package Visitor;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class ListenerTestGoobScraper extends GoobScraperBaseListener {

    private static Map<String,Variable> varMem = new HashMap<>();
    private static Variable lastVar;

    public ListenerTestGoobScraper() {  }

    @Override
    public void exitGetURL(GoobScraperParser.GetURLContext ctx) {
        System.out.println("In exitGetURL");
        System.out.println(ctx.word().getText());
        URLConnection connection = null;
        String url = ctx.word().getText().replace("\"", "");
        StringBuilder sb = new StringBuilder();
        for(ParseTree child: ctx.children){
            sb.append(child.getText() + " ");
        }
        String sba = sb.toString().replace("\"", "");
        String code = "import requests\n" +
                "from bs4 import BeautifulSoup\n" +
                "memory = {} # map for memory\n" +
                "#global lastVar\n" +
                "lastVar = -1\n" +
                "\n" +
                "\n" +
                "\n" +
                "from enum import Enum\n" +
                "class G_Num(Enum):\n" +
                "    G = 0\n" +
                "    def inc(self):\n" +
                "        current_num = G_Num.G.value\n" +
                "        current_num += 1\n" +
                "        G_Num.value = current_num\n" +
                "\n" +
                "\n" +
                "class Variable(object):\n" +
                "    text = \"\"\n" +
                "    url = \"\"\n" +
                "    steps = []\n" +
                "    number = 0\n" +
                "\n" +
                "    def __init__(self,text,url,number):\n" +
                "        self.text = text\n" +
                "        self.url = url\n" +
                "        self.number = G_Num.G\n" +
                "        G_Num.G.inc()\n" +
                "\n" +
                "    def getSteps(self):\n" +
                "        return self.steps\n" +
                "    def addStep(self,step):\n" +
                "        self.steps.append(step)\n" +
                "    def getText(self):\n" +
                "        return self.text\n" +
                "    def setText(self,text):\n" +
                "        self.text = text\n" +
                "        return self.text\n" +
                "    def getURLName(self):\n" +
                "        return self.url\n" +
                "def getURL(url):\n" +
                "    global lastVar\n" +
                "    lastVar += 1\n" +
                "    response = requests.get(url)\n" +
                "    var = Variable(url=url,text=response.text,number=lastVar)\n" +
                "    memory[lastVar] = var\n" +
                "    print(\"Variable reference name: \" + str(lastVar))\n" +
                "    var.addStep(\"/get " + removeLastChar(sba) + "\")\n" +
                "    return response\n" +
                "res = getURL(\""+ url + "\")\n";

        writeToPy(code);

    }
    public String removeLastChar(String s) {
        return Optional.ofNullable(s)
                .filter(str -> str.length() != 0)
                .map(str -> str.substring(0, str.length() - 1))
                .orElse(s);
    }

    //ex. "/get table 0; or "/get table";
    @Override
    public void exitGetTable(GoobScraperParser.GetTableContext ctx) {
        String pyLine= "",pyLine2 = "";
        System.out.println("In exitGetTable");
        int wordNum = ctx.children.size() - 1;
        if(wordNum == 1){
            pyLine = "html = memory[lastVar].getText()";
            pyLine2 = "var = memory[lastVar]";

        }else if(wordNum == 2){
            String varNum = ctx.getChild(2).getText();//get from memory
            pyLine = "html = memory[" + varNum + "].getText()";
            pyLine2 = "var = memory[" + varNum + "]";

        }
        StringBuilder sb = new StringBuilder();
        for(ParseTree child: ctx.children){
            sb.append(child.getText() + " ");
        }
        String sba = sb.toString().replace("\"", "");

        String code =
                "def getTable():\n" +
                "    try:\n" +
                "        data = []\n" +
                "        " + pyLine + "\n" +
                "        soup = BeautifulSoup(html,\"lxml\")\n" +
                "        table = soup.find( \"table\")\n" +
                "        rows = table.find_all('tr')\n" +
                "        for row in rows:\n" +
                "            cols = row.findAll('td')\n" +
                "            if cols != []:\n" +
                "                cols = [ele.text.strip() for ele in cols]\n" +
                "                data.append([ele for ele in cols if ele != []])  # Get rid of empty values\n" +
                "        " + pyLine2 + "\n" +
                "        var.setText(data)\n" +
                "        var.addStep(\"/get "+ removeLastChar(sba) + "\")#add java var here\n" +
                "    except ValueError:\n" +
                "        \"No variable there\"\n" +
                "tables = getTable()\n";

        writeToPy(code);

    }

    @Override
    public void exitExtractStatment(GoobScraperParser.ExtractStatmentContext ctx) {
        String file = "";
        String pyLine = "";
        int wordNum = ctx.word().size() -1;
        if(wordNum == 1){//extract new "asdf.csv";
            file = ctx.getChild(2).getText();
            pyLine = "    var = memory[lastVar]\n";

        }else if(wordNum == 2){//extract new 0 "asdf.csv";
            String varNum = ctx.getChild(2).getText();//get from memory
            file = ctx.getChild(3).getText();
            pyLine = "    var = memory[" + varNum + "]\n";

        }
        String typeExtract = ctx.getChild(1).getText();
        if(typeExtract.equals("append")){
            typeExtract = "a";
        }else{
            typeExtract = "w";
        }
        StringBuilder sb = new StringBuilder();
        for(ParseTree child: ctx.children){
            if(!child.getText().equals(";")){
                sb.append(child.getText() + " ");
            }
        }
        String sba = sb.toString().replace("\"", "");

        String code = "def extractStat():\n" +
                "    import pandas as pd\n" +
                     pyLine +
                "    lister = var.getText()\n" +
                "    my_df = pd.DataFrame(lister)\n" +
                "    md_file = open('filename_MD.txt', mode='a')\n" +
                "    ###function\n" +
                "    var.addStep(\"" + removeLastChar(sba) + "\")#add java var here\n" +
                "    md_file.write(\"Steps:\\n\")\n" +
                "    for step in var.getSteps():\n" +
                "        md_file.write(step + \"\\n\")\n" +
                "    md_file.write(\"End Steps\\n\")\n" +
                "    md_file.write(\"\\n\")\n" +
                "    my_df.to_csv('testTable.csv',mode='w', index=False, header=False)\n" +
                "    print('Extract successful: ' + str(lastVar))\n" +
                "extractStat()\n";
        writeToPy(code);

    }
    // ex. /update append 23sec
    @Override
    public void exitUpdateStatment(GoobScraperParser.UpdateStatmentContext ctx) {
        String pyLine = "";
        String file = "";
        int wordNum = ctx.children.size() - 3;
        if(wordNum == 1){//updatet new "asdf.csv";
            file = ctx.getChild(2).getText();
            pyLine = "    var = memory[lastVar]\n";

        }else if(wordNum == 2){//update new 0 "asdf.csv";
            String varNum = ctx.getChild(2).getText();//get from memory
            file = ctx.getChild(3).getText();
            pyLine = "    var = memory[" + varNum + "]\n";

        }
        String typeExtract = ctx.getChild(1).getText();
        if(typeExtract.equals("append")){
            typeExtract = "a";
        }else{
            typeExtract = "w";
        }


        StringBuilder sb = new StringBuilder();
        for(ParseTree child: ctx.children){
            sb.append(child.getText() + " ");
        }
        String sba = sb.toString().replace("\"", "");
        String updateType = ctx.getChild(1).getText();
        String updateTime = ctx.getChild(2).getText();
        String code = "def updateStat():\n" +
                           pyLine +
                      "    md_file = open('filename_MD.txt', mode='a')\n" +
                      "    md_file.write(\"update: " + updateType + ";" + updateTime + "\")\n" +
                      "    md_file.write(\"\\n\")\n" +
                      "    var.addStep(\"" + sba + "\")#add java var here\n" +
                      "updateStat()\n";
        writeToPy(code);
    }

    @Override
    public void exitAlertStatment(GoobScraperParser.AlertStatmentContext ctx) {
        String alert = "alert: true";
        String code = "def alertStat():\n" +
                      "    md_file = open('filename_MD.txt', mode='a')\n" +
                      "    md_file.write(\"" + alert + "\")\n" +
                      "    md_file.write(\"\\n\")\n" +
                      "alertStat()\n";
        writeToPy(code);

    }

    @Override
    public void exitQuitStatment(GoobScraperParser.QuitStatmentContext ctx) {
        String code = "import sys\n" +
                      "def quitStat():\n" +
                      "    print(\"quitting\")\n" +
                      "    sys.exit(0)\n" +
                      "quitStat()";
        writeToPy(code);

    }

    private void writeToPy(String code){
        try(FileWriter fw = new FileWriter("testGoober.py", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)){
            out.print(code);
            //fw.close();
        } catch (IOException e) {
            //exception handling
        }
    }


    public static void main(String[] args) throws IOException {
        String fileName = "./src/main/java/Visitor/input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                parseAndRunLine(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void parseAndRunLine(String inputLine) {
        System.out.println("In Listener");
        CharStream input = CharStreams.fromString(inputLine);
        GoobScraperLexer lexer = new GoobScraperLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        GoobScraperParser parser = new GoobScraperParser(commonTokenStream);
        ParseTree tree = parser.program();
        // Create a generic parse tree walker that can trigger callbacks
        ParseTreeWalker walker = new ParseTreeWalker();
        // Walk the tree created during the parse, trigger callbacks
        walker.walk(new ListenerTestGoobScraper(), tree);
    }

}
