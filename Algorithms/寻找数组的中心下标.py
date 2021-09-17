class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        num_sum = sum(nums)
        cur_sum = 0
        for i, num in enumerate(nums):
            cur_sum
            if cur_sum == num_sum - num - cur_sum:
                return i
            cur_sum += num
        return -1