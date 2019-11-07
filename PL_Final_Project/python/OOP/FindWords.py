class FindWords:
	def __init__(self):
		pass
    
	def process(self,data):
		split_words = []
		words = data.split("\\n")
		for line in words:
			words = line.split()
			for word in words:
				split_words.append(word)
		return split_words
