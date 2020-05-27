from collections import defaultdict 

class WordDistance:

    def __init__(self, words):
        self.word2indexs = defaultdict(list)

        for i, word in enumerate(words):
            self.word2indexs[word].append((i, word))


    def shortest(self, word1: str, word2: str) -> int:
        word1indexs = self.word2indexs[word1]
        word2indexs = self.word2indexs[word2]

        i, j = 0, 0
        res = []
        while i < len(word1indexs) and j < len(word2indexs):
            if word1indexs[i][0] < word2indexs[j][0]:
                res.append(word1indexs[i])
                i += 1
            else:
                res.append(word2indexs[j])
                j += 1

        res += word1indexs[i:]
        res += word2indexs[j:]

        result = 100000
        for i in range(1, len(res)):
            if res[i][1] != res[i-1][1]:
                result = min(result, res[i][0] - res[i-1][0])

        return result