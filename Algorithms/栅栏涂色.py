class Solution:
    def numWays(self, n: int, k: int) -> int:
        if n == 0 or k == 0:
            return 0
        if k == 1:
            return 1 if n <= 2 else 0
        if n == 1:
            return k

        dp = [(0, 0) for _ in range(n)]
        dp[0] = (0, k)
        for i in range(1, n):
            dp[i] = (dp[i-1][1], (dp[i-1][0] + dp[i-1][1]) * (k - 1))

        return dp[n-1][0] + dp[n-1][1]