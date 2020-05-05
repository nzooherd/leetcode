class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        if m == 0 and n == 0:
            return 0
        if len(strs) == 0:
            return 0
        dp = []
        for i in range(len(strs) + 1):
            item = []
            for j in range(0, m + 1):
                item.append([0] * (n + 1))
            dp.append(item)

        for i in range(1, len(strs) + 1):
            s = strs[i - 1] 
            num0, num1 = 0, 0
            for c in s:
                if c == '0':
                    num0 += 1
                else:
                    num1 += 1
            for j in range(0, m + 1):
                for k in range(0, n + 1):
                    dp[i][j][k] = dp[i-1][j][k]
                    if j >= num0 and k >= num1:
                        dp[i][j][k] = max(1 + dp[i-1][j-num0][k-num1], dp[i][j][k])

        return dp[len(strs)][m][n]