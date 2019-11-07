""" Input: 
1) a string containing the text to search for
, can be comprised of a single word, or of multiple words surrounded by double quote marks  
2) a path to the file to search 
Output : every line in the file in which the given string appears.

Filter-Lines: filter out lines that don’t meet grep search criteria """ 
class CountWords:
	def __init__(self):
		pass
    
	def process(self,data):
		word_counts = {}
		for word in data:
			if not(word in word_counts):
				word_counts[word] = 1
			else:
				word_counts[word] += 1
		return word_counts

# printing the words and its occurrence.
#for  (word,occurance)  in wordCounter.items(): 
 # print('{:15}{:3}'.format(word,occurance))