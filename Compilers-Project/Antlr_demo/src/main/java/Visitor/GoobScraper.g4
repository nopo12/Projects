grammar GoobScraper;

program: statment+;

statment: '/get' get ';'                                #GetStatment
        | '/extract' extract (word)? (word) ';'         #ExtractStatment
        | '/update' update word? time ';'               #UpdateStatment
        | '/alert' alert ';'                       #AlertStatment
        | '/quit' ';'                                   #QuitStatment
        ;

get : (word) (word)?                     #RegularGet
    | 'url' (word)                 #GetURL
    | ('tables' | 'table') (word)? #GetTable
    ;

extract : 'append'   #ExtractAppend
        |  'new'     #ExtractNew
        ;

update : 'append'   #UpdateAppend
       | 'new' #UpdateNew
       ;

alert : word    #AlertWord
      |         #AlertEmpty
      ;

time : NUMBER ('sec' | 'min' | 'hrs' | 'day');

word : ID    #WordID
    | NUMBER #WordNumber
    | STRING #WordString
    ;

STRING : '"' (~[\r\n"])* '"';
ID     : [A-Za-z]+ ;
NUMBER : [0-9]+ ;
WS     : [ \n\t\r]+ -> skip;
