class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        dp = []
        for i in range(0, len(nums) + 1):
            dp.append([0] * 3)

        for i in range(1, len(nums) + 1):
            dp[i][0] = dp[i-1][0]
            if(dp[i-1][(3 - nums[i-1] % 3) % 3]) != 0 or nums[i-1] % 3 == 0:
                dp[i][0] = max(dp[i][0], dp[i-1][(3 - nums[i-1] % 3) % 3] + nums[i-1])

            dp[i][1] = dp[i-1][1]
            if(dp[i-1][(4 - nums[i-1] % 3) % 3] != 0) or nums[i-1] % 3 == 1:
                dp[i][1] = max(dp[i][1], nums[i-1] + dp[i-1][(4 - nums[i-1] % 3) % 3])

            dp[i][2] = dp[i-1][2]
            if(dp[i-1][(5 - nums[i-1] % 3) % 3] != 0) or nums[i-1] % 3 == 2:
                dp[i][2] = max(dp[i][2], nums[i-1] + dp[i-1][(5 - nums[i-1] % 3) % 3])


        return dp[len(nums)][0]