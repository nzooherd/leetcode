class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s or len(s) == 0 or s[0] == '0':
            return 0
        dp = [1]
        for i in range(1, len(s)):
            if int(s[i]) == 0:
                if int(s[i - 1]) == 0 or int(s[i - 1]) > 2:
                    return 0
                dp.append(dp[i-2] if i >= 2 else 1)
                continue


            num = dp[i - 1]
            if i >= 1 and int(s[i-1]) != 0 and (int(s[i-1]) * 10 + int(s[i])) <= 26:
                num += dp[i - 2] if i >= 2 else 1
            dp.append(num)
        
        return dp[len(s) - 1]