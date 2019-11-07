class FilterLines{
    constructor(wordStr){
        this.wordStr = wordStr;
    }
    process(data){
        data = data.split("\n");
        let filtered = [];
        let wordStr = this.wordStr.replace("\"", "");
        data.forEach(line => {
            if(line.indexOf(wordStr) >= 0){
                filtered.push(line);
            }
        });
        return filtered.join("\n");
    }
}

class ConvertCase{
    constructor(){
    }
    process(data){
        return data.toLowerCase();
    }
}

class FindWords{
    constructor(){
    }
    process(data){
        let splitWords = [];
        let words = data.split("\n");
        words.forEach(line => {
            let splitLine = line.split(" ");
            for(let i =0; i < splitLine.length;i++){
                if(splitLine[i] !== ""){
                    splitWords.push(splitLine[i]);
                }
            }
        });
        return splitWords;
    }
}

class NonAlphaFilter{
    constructor(){

    }
    process(data){
        let alphaOnly = [];
        data.forEach(word => {
            let newWord = word.replace(/\W/g, '');
            if(newWord !== ""){
                alphaOnly.push(newWord);
            }
        });
        return alphaOnly;
    }
}

class CountWords{
    constructor(){
    }
    process(data){
        let mapResult = new Map();
        let word = "";
        data.forEach(word => {
            if(!mapResult.has(word)){
                mapResult.set(word,1);
            }else{
                mapResult.set(word, mapResult.get(word) + 1);
            }
        });
        return mapResult;
    }
}

class DocumentProcessor{

    constructor(build){
        this.filterLines = build.filterLines;
        this.convertCase = build.convertCase;
        this.findWords = build.findWords;
        this.nonAlphaFilter = build.nonAlphaFilter;
        this.countWords = build.countWords;
    }

    process(data){
        if(this.convertCase === undefined){//it must be grep
            return this.filterLines.process(data);
        }
        else if(this.filterLines === undefined){//wc
            return this.countWords.process(this.nonAlphaFilter.process(this.findWords.process(this.convertCase.process(data))));
        }
        else{//grep|wc
            return this.countWords.process(this.nonAlphaFilter.process(
                this.findWords.process(this.convertCase.process(this.filterLines.process(data)))));
        }
        
    }

    static get Builder() {
        class Builder {

            constructor(data) {
                this.data = data;
            }
            setLineFilter(lf) {
                this.filterLines = lf;
                return this;
            }
            setConvertCase(cc) {
                this.convertCase = cc;
                return this;
            }
            setFindWords(fw) {
                this.findWords = fw;
                return this;
            }
            setNonAlphaFilter(nonalpha) {
                this.nonAlphaFilter = nonalpha;
                return this;
            }

            setCountWords(cw) {
                this.countWords = cw;
                return this;
            }

            build() {
                let dp = new DocumentProcessor(this);
                return dp;
            }
        }
        return Builder;
    }
}

function readFile(filename) {
    //Make sure we got a filename on the command line.
    if (process.argv.length < 3) {
        console.log('Usage: node ' + filename + ' FILENAME');
        process.exit(1);
    }
    // Read the file and save its contents to a file.
    let fs = require("fs");
    let text = fs.readFileSync(filename).toString('utf-8');
    //let textByLine = text.split("\n");
    return text;
}


class MyMain {
    constructor(argv){
        this.argv = argv;
    }
    process(){
        const argc = process.argv.length;
        //grep word(s) silly.txt
        if(argc > 3 && process.argv[2] === "grep" && process.argv[argc - 2] !== "|"){
            console.log("Running grep\n");
            let search_str = process.argv.slice(3, argc - 1).join(" ");
            let data = readFile(process.argv[argc - 1]);
            let lf = new FilterLines(search_str);
            let dc = new DocumentProcessor.Builder(data).setLineFilter(lf).build();
            console.log(dc.process(data));
        }
        else if(argc > 2 && "wc" === process.argv[2]){//wc silly.txt
            console.log("running wc");
            let convertCase = new ConvertCase();
            let findWords = new FindWords();
            let nonAlphaFilter = new NonAlphaFilter();
            let countWords = new CountWords();
            let data = readFile(process.argv[argc - 1]);
            let dc = new DocumentProcessor.Builder(data).setConvertCase(convertCase).setFindWords(findWords).setNonAlphaFilter(nonAlphaFilter).setCountWords(countWords).build();
            console.log(dc.process(data));
        }else{//grep this silly.txt | wc
            console.log("Runnning grep_wc\n");
            let search_str = process.argv.slice(3, argc -3).join(" ");
            let data = readFile(process.argv[argc - 3]);
            let lf = new FilterLines(search_str);
            let convertCase = new ConvertCase();
            let findWords = new FindWords();
            let nonAlphaFilter = new NonAlphaFilter();
            let countWords = new CountWords();
            let dc = new DocumentProcessor.Builder(data).setLineFilter(lf).setConvertCase(convertCase).setFindWords(findWords).setNonAlphaFilter(nonAlphaFilter).setCountWords(countWords).build();
            console.log(dc.process(data));
        }
        //let data = readFile("/home/noah/Documents/CS_HW/PL/Final_Project/silly.txt");

    }

}
//Run the builder main method
myMain = new MyMain(process.argv).process();

