class Solution:
    def new21Game(self, N: int, K: int, W: int) -> float:
        if K == 0:
            return 1
        dp = [0] * (K + 1)
        dp[1] = (N - K + 1) / W
        dp[1] = 1 if dp[1] > 1 else dp[1]
        for i in range(2, K + 1):
            dp[i] = W * dp[i - 1]
            if i + N - K - 1 < W:
                dp[i] -= 0 
            elif i + N - K - 1 >= 0 and i - 1 <= W:
                dp[i] -= 1
            else:
                dp[i] -= dp[i - W - 1]

            dp[i] += dp[i - 1]
            dp[i] /= W

        return dp[K]