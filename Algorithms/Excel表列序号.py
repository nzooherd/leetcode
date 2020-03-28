class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        result = 0
        for c in s:
            result *= 26
            result += ord(c) - ord('A') + 1
            
        return result