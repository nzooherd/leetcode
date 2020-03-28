#
# @lc app=leetcode.cn id=56 lang=python
#
# [56] 合并区间
#
class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        result = []
        if not intervals:
            return result
        intervals = sorted(intervals, cmp=lambda x, y:cmp(x[0], y[0]))
        current = []
        for i in range(0, len(intervals)):
            interval = intervals[i]
            if not current:
                current = interval[:]
            elif interval[0] <= current[1]:
                current[1] = max(current[1], interval[1])
            else:
                result.append(current)
                current = interval
        result.append(current)

        return result


