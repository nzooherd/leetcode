class Solution:
    def shortestWordDistance(self, words: List[str], word1: str, word2: str) -> int:
        result, a, b = float(inf), -float(inf), float(inf)
        for word1, word2 in [(word1, word2), (word2, word1)]:
            for i, word in enumerate(words):
                if word == word1:
                    if(word != word2):
                        a = i
                if word == word2:
                    result = min(result, i - a)
                    if word == word1:
                        a = i
            a = -float(inf)

        return result