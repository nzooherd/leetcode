class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        left, max_value = nums[0], 0
        for i, num in enumerate(nums):
            if num > max_value:
                left = i
                max_value = num

        max_value, right = (nums[0], 0) if left != 0 else (nums[1], 1)
        for j, num in enumerate(nums):
            if j == left:
                continue
            if num > max_value:
                right = j
                max_value = num

        return (nums[left] - 1) * (nums[right] - 1)
