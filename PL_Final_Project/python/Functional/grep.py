#!/usr/bin/python3
from functools import reduce
from sys import argv
import re

"""
input: a path to the file to search
output: a list of all unique words in the file, and the number of times each word appears.
It ignores and removes punctuation, capitalization, and white space.
"""


def grep(wordlist,search_line):
    """
    1.Filter-Lines: filter out lines that don’t meet grep search criteria
    """
    search_line = search_line.replace("\"", "")
    return "".join(map(str,filter(lambda line: search_line in line, wordlist)))


def to_lower_case(word):
    # make each char a lower case version of it
    lower_case = list(map(lambda char: char.lower(), word))
    return "".join(lower_case)


def wc(wordlist):
    """
    Word Count
    """
    # 2. Convert - Case: put everything in lowercase
    convert_case = list(map(lambda sentence: sentence.lower(), wordlist))
    # 3. Find - Words: split the text into individual words
    split_words = list(map(lambda line: list(filter(lambda word: word, line.split())), convert_case))
    # [word for line in wordlist for word in line.split()]
    merge_lists = list(reduce(lambda x, y: x + y, split_words))
    # 4. Non - Alphabetic - Filter: strip out all non - alphabetic characters. Eliminate any “words” that are just white space.
    wf = list(filter(None, map(lambda word: re.sub('[^a-zA-Z0-9]', '', word), merge_lists)))
    # 5. Count - Words: produce a set of unique words and the number of times they each appear
    wc = list(map(lambda y: word_counter(y, wf), wf))
    # convert to unique list of tuples
    reducer = list(set(map(lambda x, y: convert_to_tuple(x, y), wf, wc)))
    return reducer


def convert_to_tuple(wf, wc):
    return (wf, wc)


def word_counter(word, non_alpha):
    return reduce(lambda x, y: (x + y), map(lambda x: x == word, non_alpha))


def main():
    """
    Main Method
    """
    #filename = '../../' + filename
    #grep word(s) file
    if (len(argv) > 3 and "grep" == argv[1] and "|" != argv[len(argv) -2]):
        search_str = " ".join(argv[2:len(argv) - 1])
        filename = argv[len(argv) - 1]
        wordlist = open(filename, 'r')
        grepP = grep(wordlist=wordlist, search_line=search_str)
        print(grepP)
    elif(len(argv) > 2 and "wc" == argv[1]):
        filename = argv[len(argv) - 1]
        wordlist = open(filename, 'r')
        result = wc(wordlist=wordlist)
        result.sort() #sort list alphabetically
        list(map(lambda result: print(result[0] + " " + str(result[1])), result))
    else:
        search_str = " ".join(argv[2:len(argv) - 3])
        filename = argv[len(argv) - 3]
        wordlist = open(filename, 'r')
        result = wc(grep(wordlist=wordlist,search_line=search_str).split("\n"))
        result.sort(key=lambda string: string[0] == search_str, reverse=True)# sort list starting with word searched
        list(map(lambda result: print(result[0] + " " + str(result[1])),result))
    return 0


#grep this silly.txt | wc

if __name__ == '__main__':
        main()


