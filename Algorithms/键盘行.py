class Solution:
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        rowChars = ["QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"]
        ret = []
        for i in range(len(words)):
            word = words[i]
            charStart = word[0]
            for j in range(3):
                if (charStart in rowChars[j] or (chr(ord(charStart) + ord('A') - ord('a'))) in rowChars[j]) :
                    index = j
                    break
            for j in range(len(word)):
                c = word[j]
                if not(c in rowChars[index] or (chr(ord(c) + ord('A') - ord('a'))) in rowChars[index]) :
                    break
                if (j == len(word) - 1):
                    ret.append(word)
        return ret
        