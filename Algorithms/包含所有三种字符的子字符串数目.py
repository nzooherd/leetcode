from collections import defaultdict

class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        char2count = defaultdict(int)
        start, end = 0, 2
        char2count[s[0]] += 1
        char2count[s[1]] += 1
        char2count[s[2]] += 1

        if len(s) < 3:
            return 0

        res = 0
        while(end < len(s)):
            while(end < len(s) and  not char2count['a'] * char2count['b'] * char2count['c']):
                end += 1
                if end >= len(s):
                    break
                char2count[s[end]] += 1
            res += (len(s)) - end
            char2count[s[start]] -= 1
            start += 1
        return res

                

