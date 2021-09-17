class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        from collections import defaultdict
        num2count = defaultdict(int)
        for num in nums:
            num2count[num] += 1
        diff_nums = list(num2count.keys())
        diff_nums.sort()
        result = 0
        dp = [0] * len(diff_nums)
        for i, diff_num in enumerate(diff_nums):
            if i == 0:
                dp[i] = diff_num * num2count[diff_num]
                continue
            if diff_nums[i] != diff_nums[i-1] + 1:
                dp[i] = dp[i-1] + diff_num * num2count[diff_num]
            else:
                dp[i] = max(dp[i-1], (dp[i-2] if i >= 2 else 0) + num2count[diff_num] * diff_num)

        return dp[-1]