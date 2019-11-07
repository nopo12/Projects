from DocumentProcessor import DocumentProcessor
from FilterLines import FilterLines
from ConvertCase import ConvertCase
from FindWords import FindWords
from NonAlphaFilter import NonAlphaFilter
from CountWords import CountWords
from sys import argv
class MyMain():

    def __init__(self, args):
        lf = FilterLines()
        case_convert = ConvertCase()
        find_words = FindWords()
        non_alpha = NonAlphaFilter()
        word_count = CountWords()

        # grep word(s) file
        if (len(argv) > 3 and "grep" == argv[1] and "|" != argv[len(argv) - 2]):
            print("running grep")
            search_str = " ".join(argv[2:len(argv) - 1])
            filename = argv[len(argv) - 1]
            wordlist = "".join(open(filename, 'r').readlines())

            grep_result = DocumentProcessor.Builder().setLineFilter(lf).build().process(filename=wordlist,search_str=search_str)
            print(grep_result)

        elif (len(argv) > 2 and "wc" == argv[1]):
            filename = argv[len(argv) - 1]
            wordlist = open(filename, 'r')
            mapR = DocumentProcessor.Builder().setConvertCase(case_convert).setFindWords(find_words) \
                .setNonAlphabetic(non_alpha).setCountWords(word_count).build().process(filename=filename,search_str="")
            print(mapR)

        else:
            search_str = " ".join(argv[2:len(argv) - 3])
            filename = argv[len(argv) - 3]
            wordlist = "".join(open(filename, 'r').readlines())

            mapR = DocumentProcessor.Builder().setLineFilter(lf).setConvertCase(case_convert).setFindWords(find_words) \
                .setNonAlphabetic(non_alpha).setCountWords(word_count).build().process(filename=wordlist,search_str=search_str)
            print(mapR)
def main():
    MyMain(args=argv)

if __name__ == '__main__':
        main()