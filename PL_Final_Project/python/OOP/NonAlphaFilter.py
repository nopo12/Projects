import re
class NonAlphaFilter:

	def __init__(self):
		pass
       
	def process(self,data):
		alphaOnly = []
		for word in data:
			new_word = re.sub("[^a-zA-Z0-9]", "",word)
			if new_word != "":
				alphaOnly.append(new_word)
		return alphaOnly