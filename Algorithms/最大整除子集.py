class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        nums.sort()
        dp = []
        for i, num in enumerate(nums):
            if i == 0:
                dp.append([num])
            else:
                max_len, items = 0, None
                for j in range(i-1, -1, -1):
                    if nums[i] % nums[j] == 0:
                        if len(dp[j]) > max_len:
                            items = dp[j][:]
                            max_len = len(dp[j]) 

                if items:
                    items.append(num)
                else:
                    items = [num]
                dp.append(items)

        max_len, result = 0, None
        for items in dp:
            if len(items) > max_len:
                max_len = len(items)
                result = items

        return result