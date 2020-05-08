class Solution:
    def shortestDistance(self, words: List[str], word1: str, word2: str) -> int:
        result = len(words)
        word1_index, word2_index = -1, -1
        for i, word in enumerate(words):
            if word == word1:
                word1_index = i
                if word2_index != -1:
                    result = min(result, word1_index - word2_index)
            if word == word2:
                word2_index = i
                if word1_index != -1:
                    result = min(result, word2_index - word1_index)
            
        return result