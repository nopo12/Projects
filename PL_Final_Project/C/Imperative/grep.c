/* Input: 
1) a string containing the text to search for
, can be comprised of a single word, or of multiple words surrounded by double quote marks  
2) a path to the file to search 
Output : every line in the file in which the given string appears.

Filter-Lines: filter out lines that don’t meet grep search criteria */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
#include "linkedList.h"

#define SIZE 101
char **readLines(char *filename);
int add2Dict(char *key,int value);
int match(char *word,char *line);
char **filterLines(char *word, char **strings);
int freeStrings(char **words);
int parseArgs(int argc, char **argv);
void printGrep(char **filteredLines, char *searchStr);
//Source: https://stackoverflow.com/questions/5046035/how-to-read-string-from-command-line-argument-in-c
char *buildSearchStr(int argc,char **argv,int num);
int toLowerCase(int c) ;
char **ConvertCase(char **strings);
char **FindWords(char **lowerStrs);
char **NonAlphabeticFilter(char **split_words);
void reformat_string(char *src, char *dst) ;
int CountWords(char **words);
int printDict(void);


int num_lines = 0;
int num_elements = 0;//Keeps track of the number of elements in dict

/**
 * Main Method
 * @param argc
 * @param argv
 * @return
 */
int main(int argc, char **argv){
    //executable grep this silly.txt
    if(argc > 3 && strncmp("grep",argv[1],4) == 0 && strncmp("|",argv[argc - 2],1) != 0){
        char **lineWords = readLines(argv[argc - 1]);
        char *searchStr = buildSearchStr(argc,argv,1);
        char **grep_result = filterLines(searchStr, lineWords);
        printGrep(grep_result,searchStr);
        freeStrings(lineWords);
    }
    //wc silly.txt
    else if(argc > 2 && strncmp("wc",argv[1],2) == 0){
        char **lineWords = readLines(argv[argc - 1]);
        char **lowerStrs = ConvertCase(lineWords);
        char **foundWords = FindWords(lowerStrs);
        char **noPunc = NonAlphabeticFilter(foundWords);
        CountWords(noPunc);
        printDict();
        freeStrings(lineWords);
    }else{//executable grep this silly.txt | wc
        char **lineWords = readLines(argv[argc - 3]);
        char *searchStr = buildSearchStr(argc,argv,3);
        char **grep_result = filterLines(searchStr, lineWords);
        char **lowerStrs = ConvertCase(grep_result);
        char **foundWords = FindWords(lowerStrs);
        char **noPunc = NonAlphabeticFilter(foundWords);
        CountWords(noPunc);
        printDict();
        freeStrings(lineWords);
        //freeStrings(lowerStrs);
        //freeStrings(foundWords);
    }
    return 0;
}


/**
 * Print the results of grep
 * @param filteredLines
 * @param searchStr
 */
void printGrep(char **filteredLines, char *searchStr){
    if(num_lines < 1){
        printf("No results");
    }
    for(int i = 0;i < num_lines;i++) {
        if (filteredLines[i] != NULL) {
            printf("%s\n", filteredLines[i]);
        }
    }
    free(searchStr);
}


/**
 * Add value to dictionary
 * @param key
 * @param value
 * @return
 */
int add2Dict(char *key,int value){
    insertFirst(key,value);
    num_elements++;
    return 1;
}

/**
 * Search dictionary for entry
 * @param key
 * @return
 */
struct node *searchDict(char *key){
    return find(key);
}
/**
 * Filter lines out lines that don’t meet grep search criteria
 * @param word
 * @param strings
 * @return
 */
char **filterLines(char *word, char **strings) {
    char **words = (char **)malloc(sizeof(char*) *  num_lines);
    if (words == NULL) {
        fprintf(stderr,"Out of memory (1).\n");
        return NULL;
    }
    int j = 0;
    for (int i = 0; i < num_lines; i++) {
        char *line = strings[i];
        if (strstr(line, word) != NULL){//if search string IS IN line
            words[j] = line;
            j++;
        }
    }
    num_lines = j;
    return words;
}
/**
 * Convert case to all lowercase
 * @param strings
 * @return
 */
char **ConvertCase(char **strings){
    for(int i = 0;i < num_lines;i++){
        for(int j = 0;j < strlen(strings[i]);j++){
            strings[i][j] = (char) toLowerCase(strings[i][j]);
        }
    }
    return strings;
}


/**
 * Splits the text into individual words
 * @return
 */
char **FindWords(char **lowerStrs){
    char **split_words = (char **)malloc(sizeof(char*) * 200);
    if (split_words  == NULL) {
        fprintf(stderr,"Out of memory (1).\n");
        return NULL;
    }
    memset(split_words,0,sizeof(char *) * 200);
    int index = 0;
    for(int i = 0;i < num_lines;i++){
        char *word = strtok(lowerStrs[i]," ");
        for(;word != NULL;word = strtok(NULL," ")){
            split_words[index] = word;
            index++;
        }
    }
    //freeStrings(lowerStrs);//do not need this anymore
    return split_words;
}

/**
 * Strip out all non-alphabetic characters
 * and eliminates any “words” that are just white space.
 * @return
 */
char **NonAlphabeticFilter(char **split_words){
    int i = 0;
    while(split_words[i] != NULL){
        char *current_word = split_words[i];
        reformat_string(current_word,current_word);
        i++;
    }
    return split_words;
}

/**
 * Reformat string and remove punctuation
 * @param src
 * @param dst
 */
void reformat_string(char *src, char *dst) {
    for (; *src; ++src){
        if (!ispunct((unsigned char) *src) && (unsigned)*src != -128
            && (unsigned)*src != -103 && (unsigned)*src != -30){//to remove "'" since ispunct doesn't recognize it

            *dst++ = (unsigned char) *src;
        }
    }
    *dst = 0;
}

int printDict(void){
    printList();
    return 1;
}

/**
 * Produce a set of unique words and the number of times they each appear
 * @param word
 * @param line
 * @return
 */
int CountWords(char **words){
    for(int i = 0 ; words[i] != NULL ;i++) {
        struct node *in_map = searchDict(words[i]);
        if (in_map == NULL && strncmp(words[i],"",1) > 0) {//it is not in the dictionary
            add2Dict(words[i], 1);
        }else if(strncmp(words[i],"",1) > 0){
            in_map->value++;//it was so increment value by one
        }else{
            //do nothing
        }
    }
    return 1;
}


/**
 * Convert case to lowercase
 * @param c
 * @return
 */
int toLowerCase(int c) {
    if (c >= 'A' && c <= 'Z') {
        return c + 'a' - 'A';
    }
    else {
        return c;
    }
}
/**
 * Free strings after done using them
 * @param strs
 * @return
 */
int freeStrings(char **words){
    /* Good practice to free memory*/
    int i = 0;
    while(words[i] != NULL) {
        free(words[i]);i++;
    }

    // and free the container array only now
    free(words);
    return 1;
}
/**
 * Read from stream to array of lines.
 * @param filename
 * @return
 */
char **readLines(char *filename){
    int lines_allocated = 128;
    int max_line_len = 100;
    int j;
    /* Allocate lines of text */
    char **words = (char **)malloc(sizeof(char*)*lines_allocated);
    if (words==NULL) {
        fprintf(stderr,"Out of memory (1).\n");
        exit(1);
    }

    FILE *fp = fopen(filename, "r");
    if (fp == NULL) {
        fprintf(stderr,"Error opening file.\n");
        exit(2);
    }
    int i;
    for (i=0;1;i++) {
        num_lines++;
        /* Have we gone over our line allocation? */
        if (i >= lines_allocated) {
            int new_size;

            /* Double our allocation and re-allocate */
            new_size = lines_allocated *  2;
            words = (char **)realloc(words,sizeof(char*) * new_size);
            if (words==NULL) {
                fprintf(stderr,"Out of memory.\n");
                exit(3);
            }
            lines_allocated = new_size;
        }
        /* Allocate space for the next line */
        words[i] = (char *)malloc((size_t) max_line_len);
        if (words[i] == NULL) {
            fprintf(stderr,"Out of memory (3).\n");
            exit(4);
        }
        if (fgets(words[i],max_line_len-1,fp) == NULL) break;

        /* Get rid of CR or LF at end of line */
        for (j=strlen(words[i])-1;j>=0 && (words[i][j]=='\n' || words[i][j]=='\r');j--);
        words[i][j+1]='\0';
    }
    /* Close file */
    fclose(fp);
    return words;
}

//Source: https://stackoverflow.com/questions/5046035/how-to-read-string-from-command-line-argument-in-c
/**
 * Builds a search string from the command line
 * @param argc
 * @param argv
 * @return
 */
char *buildSearchStr(int argc,char **argv,int num){
    if (argc < 1) return 0;
    int is_grep = 4;//if it is grep | wc
    if(num == 1){
        is_grep = 2;//it is just grep
    }

    size_t strsize = 0;
    for (int i=1; i < argc - num; i++) {
        strsize += strlen(argv[i]);
        if (argc > i+1) {
            strsize++;
        }
    }

    char *cmdstring;
    cmdstring = (char *)malloc(strsize);
    cmdstring[0] = '\0';

    for (int j = 2; j < argc - num; j++) {
        strcat(cmdstring, argv[j]);
        if (argc > j + is_grep) {
            strcat(cmdstring, " ");
        }
    }
    return cmdstring;
}