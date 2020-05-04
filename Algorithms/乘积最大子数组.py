class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]

        dp = [(nums[0], nums[0])] * len(nums)
        for i in range(1, len(nums)):
            if nums[i] == 0:
                dp[i] = (0, 0)
            max_value = max(nums[i], nums[i] * dp[i-1][0 if nums[i] > 0 else 1])
            min_value = min(nums[i], nums[i] * dp[i-1][1 if nums[i] > 0 else 0])

            dp[i] = (max_value, min_value)

        return max([_[0] for _ in dp])
