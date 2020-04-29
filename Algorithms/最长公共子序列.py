class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        if len(text1) < 1 or len(text2) < 1:
            return 0
        dp =  []
        for i in range(0, len(text1) + 1):
            dp.append([0] * (len(text2)+1) )
        for i in range(1, len(text1) + 1):
            for j in range(1, len(text2) + 1):
                if text2[j-1] == text1[i-1]:
                    dp[i][j] = 1 + dp[i-1][j - 1]
                else:
                    dp[i][j] = max(dp[i][j-1], dp[i-1][j])
        
        return dp[len(text1)][len(text2)]