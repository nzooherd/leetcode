#
# @lc app=leetcode.cn id=22 lang=python
#
# [22] 括号生成
#
import Queue
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        if n <= 0:
            return []

        result = []
        queue = Queue.Queue() 
        queue.put(("(", 1, 1))
        while not queue.empty():
            backets_str, can_expend, num_right = queue.get()
            if num_right == n:
                backets_str += ")" * (2 * n - len(backets_str))
                result.append(backets_str)
                continue
            if can_expend > 0:
                backets_str2 = backets_str + ")"
                queue.put((backets_str2, can_expend - 1, num_right))

            backets_str1 = backets_str + "("
            queue.put((backets_str1, can_expend + 1, num_right + 1))
           
        return result
            


        

