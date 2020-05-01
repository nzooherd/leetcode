class Solution:

    def soupServings(self, N: int) -> float:
        if N <= 0:
            return 0.5
        if N >= 5000:
            return 1
        x = int(N / 25) + (1 if N % 25 != 0 else 0)
        y = x
        dp = []
        for i in range(0, x+1):
            dp.append([0] * (x+1 ))

        for i in range(1, x+1):
            for j in range(1, x+1):
                value = 0
                for diff in range(1, 5):
                    l = i - diff
                    r = j + diff - 4
                    if l > 0 and r <= 0:
                        value += 0
                        continue
                    if l <= 0:
                        value += 0.5 if r <= 0 else 1
                        continue
                    value += dp[l][r]
                value /= 4
                dp[i][j] = value

        return dp[x][x]
