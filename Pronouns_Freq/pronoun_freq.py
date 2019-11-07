import nltk
import re
from nltk.corpus import stopwords
import itertools
from sys import argv

def get_distance_bt(words,w1, w2):
    if w1 in words and w2 in words:
        w1_indexes = [index for index, value in enumerate(words) if value == w1]    
        w2_indexes = [index for index, value in enumerate(words) if value == w2]    
        distances = [abs(item[0] - item[1]) for item in itertools.product(w1_indexes, w2_indexes)]
        return {'min': min(distances) - 1, 'avg': sum(distances) /float(len(distances))}

def get_distance_bt_chars(words,w1, w2):
    if w1 in words and w2 in words:
        """
        wordlist = []
        for index,value in enumerate(words):
            if value == w1:
                wordlist.append()
        """
        w1_indexes = [index for index, value in enumerate(words) if value == w1]    
        w2_indexes = [index for index, value in enumerate(words) if value == w2]    
        distances = [abs(item[0] - item[1]) for item in itertools.product(w1_indexes, w2_indexes)]
        return {'min': min(distances) - 1, 'avg': sum(distances) /float(len(distances))}



#default_stopwords = set(nltk.corpus.stopwords.words('english'))
def read_letter(filename):
    fp = open(filename,'r')
    txt = nltk.word_tokenize(fp.read())
    # Lowercase all words (default_stopwords are lowercase too)
    words = list(map(lambda word: word.lower(), txt))
    return words

def calulate_freq(words): # Calculate frequency distribution
    fdist = nltk.FreqDist(words)
    percent_i = fdist['i'] / len(words)
    percent_me = fdist['me'] / len(words)
    return percent_i,percent_me

def calc_distance_chars(words):
    char_dist = get_distance_bt_chars(words,'i','me')
    return char_dist

def calc_distance_words(words):
    # Remove numbers
    words = [word for word in words if not word.isnumeric()]
    # remove all punctuation
    words = list(filter(None, map(lambda word: re.sub('[^a-zA-Z0-9]', '', word),words)))
    word_dist = get_distance_bt(words,'i','me')
    return word_dist,words



def main():
    words = read_letter(argv[1])
    char_dist = calc_distance_chars(words)
    word_dist,final_words = calc_distance_words(words)
    percent_i,percent_me = calulate_freq(final_words)
    print("Percentage of I: " + "{:.2%}".format(percent_i))
    print("Percentage of me: " + "{:.2%}".format(percent_me))
    print("Char Distance: " +  str(char_dist))
    print("Word Distance: " +  str(word_dist))
    

if __name__ == "__main__":
    main()
