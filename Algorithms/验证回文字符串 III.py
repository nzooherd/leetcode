class Solution(object):
    def isValidPalindrome(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: bool
        """
        reverse_s = s[::-1]
        if not s or len(s) == 1:
            return True

        dp = [[0] * len(s) for _ in s]
        for i in range(0, len(s)):
            for j in range(0, len(s)):
                if s[i] != reverse_s[j]:
                    dp[i][j] = max(dp[i][j-1] if j > 0 else 0, dp[i-1][j] if i > 0 else 0)
                    continue

                if i == 0 or j == 0:
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i-1][j-1] + 1

        return len(s) - dp[len(s) - 1][len(s) - 1] <= k