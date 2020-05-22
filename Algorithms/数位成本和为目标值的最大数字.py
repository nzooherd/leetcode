class Solution:
    def largestNumber(self, cost: List[int], target: int) -> str:
        dp = [''] + ['@'] * target

        for i in range(0, 9):
            for j in range(cost[i], target+1):
                if dp[j - cost[i]] == '@':
                    continue
                if len(dp[j]) <= len(dp[j-cost[i]]) + 1:
                    dp[j] = str(i+1) + dp[j - cost[i]]

        return dp[target] if dp[target] != '@' else '0'
