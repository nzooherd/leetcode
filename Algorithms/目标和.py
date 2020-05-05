class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        sum_value = sum(nums) 
        if S > sum_value or S < -sum_value:
            return 0
        dp = []
        for i in range(0, len(nums) + 1):
            dp.append([0] * (2 * sum_value + 1))
        dp[0][sum_value] = 1

        for i in range(1, len(nums) + 1):
            for j in range(0, 2 * sum_value + 1):
                if (j + nums[i-1] <= 2 * sum_value):
                    dp[i][j] += dp[i-1][j + nums[i-1]]
                if (j - nums[i-1] >= 0):
                    dp[i][j] += dp[i-1][j - nums[i-1]]

        return dp[len(nums)][S + sum_value]