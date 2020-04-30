import functools
from collections import defaultdict

class Solution:
    def strangePrinter(self, s: str) -> int:
        not_repeat_str = "0"
        for c in s:
            if c == not_repeat_str[-1]:
                continue
            not_repeat_str += c
        not_repeat_str = not_repeat_str[1:]
        if not not_repeat_str:
            return 0

        reverse_index = defaultdict(list)
        for i, c in enumerate(not_repeat_str):
            reverse_index[c].append(i)


        dp = []
        size = len(not_repeat_str)
        for i in range(0, size):
            dp.append([0] * size)

        for i in range(0, size):
            dp[i][i] = 1


        for length in range(2, size+1):
            for left in range(0, size - length + 1):
                right = left + length - 1
                if length == 1:
                    if not_repeat_str[left] == not_repeat_str[right]:
                        dp[left][right] = 1
                    else:
                        dp[left][right] = 2
                    continue

                min_value = 101
                for mid in range(left, right):
                    if not_repeat_str[mid+1] == not_repeat_str[left]:
                        min_value = min(min_value, dp[left][mid] + dp[mid+1][right] - 1)
                    else:
                        min_value = min(min_value, dp[left][mid] + dp[mid+1][right])

                dp[left][right] = min_value

        return dp[0][size-1]