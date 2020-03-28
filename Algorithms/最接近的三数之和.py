#
# @lc app=leetcode.cn id=16 lang=python
#
# [16] 最接近的三数之和
#
class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums = sorted(nums) 
        min_margin_abs = abs(nums[0] + nums[1] + nums[2] - target)
        min_margin_sum = nums[0] + nums[1] + nums[2]
        for i in range(0, len(nums)):
            start = i + 1
            end = len(nums) - 1
            while start < end:
                margin = nums[i] + nums[start] + nums[end] - target
                if margin == 0:
                    return target
                if margin < 0:
                    start += 1
                else:
                    end -= 1
                if abs(margin) < min_margin_abs:
                    min_margin_abs = abs(margin)
                    min_margin_sum = margin + target
        return min_margin_sum

