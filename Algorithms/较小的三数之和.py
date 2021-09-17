class Solution:
    def threeSumSmaller(self, nums: List[int], target: int) -> int:
        if len(nums) < 3:
            return 0

        nums.sort()
        res = 0

        for i in range(2, len(nums)):
            left, right = 0, i - 1
            cur_target = target - nums[i]
            while(left < right):
                while(left < right and nums[left] + nums[right] >= cur_target):
                    right -= 1
                if left < right:
                    res += right - left
                    left += 1

        return res

