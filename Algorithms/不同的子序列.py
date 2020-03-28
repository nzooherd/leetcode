class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        if not s:
            return 0 if t else 1
        if not t:
            return 1

        if len(t) > len(s):
            return 0
        if len(t) == len(s):
            return 1 if s == t else 0
        dp = [0 for _ in s] 
        for i in range(0, len(s)):
            dp[i] = [0 for _ in t]

        for i in range(0, len(s)):
            if s[i] == t[0]:
                dp[i][0] = dp[i-1][0] + 1 if i >= 1 else 1
            else:
                dp[i][0] = dp[i-1][0] if i >= 1 else 0
        
        for i in range(1, len(s)):
            for j in range(1, min(len(t), i + 1)):
                if s[i] == t[j]:
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
                else:
                    dp[i][j] = dp[i-1][j]

        return dp[len(s)-1][len(t)-1]