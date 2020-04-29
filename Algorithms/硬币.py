class Solution:
    def waysToChange(self, n: int) -> int:
        dp = [1] * (n+1)
        if n <= 0:
            return 0
        for i in [5, 10, 25]:
            for j in range(i, n+1):
                dp[j] += dp[j-i]
                dp[j] %= 1000000007

        return dp[n]