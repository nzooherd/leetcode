"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

class Solution:

    def superEggDrop(self, K: int, N: int) -> int:
        dp = []
        for i in range(0, K + 1):
            dp.append([0] * (N + 1))
        for i in range(1, N + 1):
            dp[1][i] = i

        for i in range(2, K + 1):
            for j in range(1, N + 1):
                if j <= 2:
                    dp[i][j] = j
                    continue

                min_value = N
                left, right = 2, j
                while(left < right):
                    mid = (left + right) // 2 
                    broken_result = dp[i-1][j - mid]
                    not_broken_result = dp[i][mid - 1]
                    if broken_result == not_broken_result:
                        min_value = broken_result
                        break
                    elif broken_result < not_broken_result:
                        right = mid
                    else:
                        left = mid + 1

                if left == right:
                    min_value = min(max(dp[i][left-1], dp[i-1][j - left]), max(dp[i][left-2], dp[i-1][j - left + 1]))


                min_value += 1
                dp[i][j] = min_value


        return dp[K][N]

