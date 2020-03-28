# -*- coding: utf-8 -*-
# @lc app=leetcode.cn id=738 lang=python
#
# [738] 单调递增的数字
#
# https://leetcode-cn.com/problems/monotone-increasing-digits/description/
#
# algorithms
# Medium (36.13%)
# Total Accepted:    789
# Total Submissions: 2.2K
# Testcase Example:  '10'
#
# 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
# 
# （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
# 
# 示例 1:
# 
# 输入: N = 10
# 输出: 9
# 
# 
# 示例 2:
# 
# 输入: N = 1234
# 输出: 1234
# 
# 
# 示例 3:
# 
# 输入: N = 332
# 输出: 299
# 
# 
# 说明: N 是在 [0, 10^9] 范围内的一个整数。
# 
#
class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        digit_list = []
        while N > 0:
            digit_list.append(N % 10)
            N /= 10
        digit_list.reverse()
        if len(digit_list) == 1:
            return digit_list[0]
        for i in range(0, len(digit_list) - 1):
            if digit_list[i] > digit_list[i + 1]:
                while i >= 1 and digit_list[i - 1] == digit_list[i]:
                    i -= 1
                digit_list[i] = digit_list[i] - 1
                i += 1
                while i < len(digit_list):
                    digit_list[i] = 9
                    i += 1
                break
        
        num = 0
        for i in digit_list:
            num += i
            num *= 10
        return num / 10

if __name__=='__main__':
    solution = Solution()
    print solution.monotoneIncreasingDigits(91023)
        

