from FilterLines import FilterLines
from ConvertCase import ConvertCase
from FindWords import FindWords
from NonAlphaFilter import NonAlphaFilter
from CountWords import CountWords
import re
from sys import argv


class DocumentProcessor:
    def __init__(self, builder):
        self.builder = builder
        self.filteredLines = self.builder.lineFilter
        self.convertCase = self.builder.convertCase
        self.findWords = self.builder.findWords
        self.nonAlpha = self.builder.nonAlphaFilter
        self.wordCount = self.builder.countWords

    def process(self, filename,search_str):
        # grep
        if self.convertCase is None:
            return self.filteredLines.process(filename,search_str=search_str)

        elif self.filteredLines is None:
            f = open(filename, "r")
            lines = str(f.readlines())
            second_step = ConvertCase().process(lines)
            third_step = FindWords().process(second_step)
            fourth_step = NonAlphaFilter().process(third_step)
            final_step = CountWords().process(fourth_step)
            return final_step
        else:
            a = self.filteredLines.process(filename,search_str)
            first_step = ConvertCase().process(a)
            second_step = ConvertCase().process(first_step)
            third_step = FindWords().process(second_step)
            fourth_step = NonAlphaFilter().process(third_step)
            final_step = CountWords().process(fourth_step)
            return final_step

    class Builder:
        def __init__(self):
            self.lineFilter = None
            self.convertCase = None
            self.findWords = None
            self.nonAlphaFilter = None
            self.countWords = None

        def setLineFilter(self, lf):
            self.lineFilter = lf
            return self

        def setConvertCase(self, cc):
            self.convertCase = cc
            return self

        def setFindWords(self, fw):
            self.findWords = fw
            return self

        def setNonAlphabetic(self, na):
            self.nonAlphabetic = na
            return self

        def setCountWords(self, cw):
            self.countWords = cw
            return self

        def build(self):
            return DocumentProcessor(self)


