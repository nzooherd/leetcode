class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        left, right = 0, 0
        result = 0
        min_value, max_value = nums[0], nums[0]
        while right < len(nums):
            right += 1
            while right < len(nums) and abs(nums[right] - min_value) <= limit and abs(max_value - nums[right]) <= limit:
                min_value = min(nums[right], min_value)
                max_value = max(nums[right], max_value)
                right += 1
            result = max(result, right - left)

            if right >= len(nums):
                break

            left = right
            min_value, max_value = nums[right], nums[right]
            while(left >= 0 and abs(nums[left] - min_value) <= limit and abs(max_value - nums[left]) <= limit):
                left -= 1
                min_value = min(nums[left], min_value)
                max_value = max(nums[left], max_value)
            if left >= 0:
                left += 1 
        return result