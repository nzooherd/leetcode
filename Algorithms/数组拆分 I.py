#
# @lc app=leetcode.cn id=561 lang=python
#
# [561] 数组拆分 I
#
class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        result = 0
        for i in range(0, len(nums), 2):
            result += nums[i]

        return result
        

