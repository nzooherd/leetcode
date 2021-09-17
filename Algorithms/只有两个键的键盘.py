class Solution:
    def minSteps(self, n: int) -> int: 
        if n == 1:
            return 0
        
        dp = [[-1] * (n+1) for _ in range(n+1)]

        dp[1][1] = 1
        for i in range(2, n+1):
            dp_i = float('inf')
            for j in range(1, i+1):
                if j != i:
                    if dp[i-j][j] == -1:
                        continue
                    dp[i][j] = dp[i-j][j] + 1
                    if(dp[i][j] < dp_i):
                        dp_i = dp[i][j]
                else:
                    dp[i][j] = dp_i + 1
            
            if i == n:
                return dp_i
        
        return -1
