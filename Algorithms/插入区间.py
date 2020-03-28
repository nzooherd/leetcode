#
# @lc app=leetcode.cn id=57 lang=python
#
# [57] 插入区间
#
class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        intervals.append(newInterval) 
        intervals = sorted(intervals)
        result = []
        current_interval = []
        for interval in intervals:
            if not current_interval: 
                current_interval = interval[:]
            elif interval[0] <= current_interval[1]:
                current_interval[1] = max(current_interval[1], interval[1])
            else:
                result.append(current_interval)
                current_interval = interval
            
        result.append(current_interval)
        return result
            


