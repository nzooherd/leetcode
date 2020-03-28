#
# @lc app=leetcode.cn id=89 lang=python
#
# [89] 格雷编码
#
import Queue
class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        res = [0]
        for i in range(n):
            head = 1 << i
            for j in range(len(res) - 1, -1, -1):
                res.append(head + res[j])
        return res
        

