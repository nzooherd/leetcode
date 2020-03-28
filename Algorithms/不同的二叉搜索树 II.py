#
# @lc app=leetcode.cn id=95 lang=python
#
# [95] 不同的二叉搜索树 II
#
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        if n == 0:
            return []
        return self.generateTreesDo(1, n)
    
    def generateTreesDo(self, start, end):
        if end < start:
            return [None]
        if end == start:
            return [TreeNode(start)]
        result = []
        for i in range(start, end + 1):
            left_nodes = self.generateTreesDo(start, i -1)
            right_nodes = self.generateTreesDo(i+1, end)
            for left_node in left_nodes:
                for right_node in right_nodes:
                    head = TreeNode(i)
                    head.left = left_node
                    head.right = right_node
                    result.append(head)
        return result

