class Solution:
    def maxUncrossedLines(self, A: List[int], B: List[int]) -> int:
        dp = [[0] * len(B) for _ in range(len(A))]

        for i in range(len(A)):
            for j in range(len(B)):
                if A[i] == B[j]:
                    dp[i][j] = 1 if (i == 0 or j == 0) else (1 + dp[i-1][j-1])
                else:
                    dp[i][j] = max(dp[i-1][j] if i != 0 else 0, dp[i][j-1] if j != 0 else 0)

        return dp[len(A) - 1][len(B) - 1]
