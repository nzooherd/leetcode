#
# @lc app=leetcode.cn id=42 lang=python
#
# [42] 接雨水
#
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        finally_height = []
        left_max, right_max = 0, 0
        for h in height:
            if h > left_max:
                left_max = h
            finally_height.append(left_max)
            
        for i in range(len(height) - 1, -1, -1):
            h = height[i]
            if h > right_max:
                right_max = h
            if right_max < finally_height[i]:
                finally_height[i] = right_max

        return sum(finally_height) - sum(height)



