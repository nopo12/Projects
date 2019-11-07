/* Input: 
1) a string containing the text to search for
, can be comprised of a single word, or of multiple words surrounded by double quote marks  
2) a path to the file to search 
Output : every line in the file in which the given string appears.
*/

function readFile(filename) {
    //Make sure we got a filename on the command line.
    if (process.argv.length < 3) {
        console.log('Usage: node ' + filename + ' FILENAME');
        process.exit(1);
    }
    // Read the file and save its contents to a file.
    let fs = require("fs");
    let text = fs.readFileSync(filename).toString('utf-8');
    let textByLine = text.split("\n");
    return textByLine;
}
//executable grep searchstr silly.txt
function grep(data,search_str){
    search_str = search_str.replace("\"", "");//remove extra quotes if there are
    //1. Filter-Lines:filter out lines that don’t meet grep search criteria.
    result = data.filter(function(line){
        return line.indexOf(search_str) >= 0;
    });
    return result.join("\n");
}
//executable wc silly.txt
function wc(data){
    return data.map(function(line){
    //2. Convert-Case: put everything in lowercase
        return line.toLowerCase();
    //3. Find-Words: split the text into individual words.
    }).map(function(line){
        return line.split(" ");
    }).reduce(function(x,y){//merge from 2d list to 1d list
        return x.concat(y);
    //4. Non-Alphabetic-Filter: strip out all non-alphabetic characters. 
    //Eliminate any “words” that are just white space.
    }).map(function(word){
        return word.replace(/\W/g, '');
    //5.Count-Words: produce a set of unique words and the number of times they each appear.    
    }).filter(function (el) {
        return el !== "";
    }).reduce((prev, curr) => (prev[curr] = ++prev[curr] || 1, prev), {});
}
//executable grep searchstr silly.txt | wc
function grep_wc(data,search_str){
    //1. Filter-Lines:filter out lines that don’t meet grep search criteria.
    return grep(data,search_str).split("\n").map(function(line){
        //2. Convert-Case: put everything in lowercase
            return line.toLowerCase();
        //3. Find-Words: split the text into individual words.
        }).map(function(line){
            return line.split(" ");
        }).reduce(function(x,y){//merge from 2d list to 1d list
            return x.concat(y);
        //4. Non-Alphabetic-Filter: strip out all non-alphabetic characters. 
        //Eliminate any “words” that are just white space.
        }).map(function(word){
            return word.replace(/\W/g, '');    
        }).filter(function (el) {
            return el !== "";
        //5.Count-Words: produce a set of unique words and the number of times they each appear.
        }).reduce((prev, curr) => (prev[curr] = ++prev[curr] || 1, prev), {});
}

function main(){
    const argc = process.argv.length;
    //grep word(s) silly.txt
    if(argc > 3 && process.argv[2] === "grep" && process.argv[argc - 2] !== "|"){
        console.log("Running grep\n");
        let search_str = process.argv.slice(3, argc - 1).join(" ");
        let data = readFile(process.argv[argc - 1]);
        let grep_result = grep(data,search_str);
        console.log(grep_result);
    }
    else if(argc > 2 && "wc" === process.argv[2]){//wc silly.txt
        console.log("running wc");
        let data = readFile(process.argv[argc - 1]);
        let result_wc = wc(data);
        console.log(result_wc);
    }else{//grep this silly.txt | wc
        console.log("Runnning grep_wc\n");
        let search_str = process.argv.slice(3, argc -3).join(" ");
        let data = readFile(process.argv[argc - 3]);
        let result_grep_wc = grep_wc(data,search_str);
        console.log(result_grep_wc);
    }
}
main();
