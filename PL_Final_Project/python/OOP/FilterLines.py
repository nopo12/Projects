class FilterLines:

	def __init__(self):
		pass
       
	def process(self,data,search_str):
		filtered = []
		search_str = search_str.replace("\"", "")
		for line in data.split("\n"):
			if search_str in line:
				filtered.append(line)
		return "\n".join(filtered)

# printing the words and its occurrence.
#for  (word,occurance)  in wordCounter.items(): 
#  print('{:15}{:3}'.format(word,occurance))
