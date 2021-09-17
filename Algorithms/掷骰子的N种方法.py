class Solution:
    def numRollsToTarget(self, d: int, f: int, target: int) -> int:
        dp = [[0] * (target + 1) for _ in range(d+1)]

        if target >= d *f:
            return 1 if target == d * f else 0
        if target <= d:
            return 1 if target == d else 0

        for i in range(1, min(target + 1, f + 1)):
            dp[1][i] = 1
        
        for i in range(2, d + 1):
            for j in range(i, target + 1):
                for k in range(1, f + 1):
                    if j > k:
                        dp[i][j] += dp[i-1][j-k]
                    else:
                        break
                dp[i][j] %= 1000000007
        
        return dp[d][target] 