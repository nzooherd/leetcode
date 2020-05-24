class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        if not sentence:
            return -1
        words = sentence.split(" ")
        if not words:
            return -1
        for i, word in enumerate(words):
            if word.startswith(searchWord):
                return i + 1

        return -1
