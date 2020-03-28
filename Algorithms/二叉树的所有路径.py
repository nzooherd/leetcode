#
# @lc app=leetcode.cn id=257 lang=python
#
# [257] 二叉树的所有路径
#
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        ret = []
        self.binaryTreePathsDo(root, [], ret)
        for i in range(0, len(ret)):
            ret[i] = "->".join([str(_) for _ in ret[i]])
        return ret
    
    def binaryTreePathsDo(self, root, path, ret):
        if not root:
            return
        path.append(root.val)
        path_temp = path[:]
        if not root.left and not root.right:
            ret.append(path)
            return
        if root.left:
            self.binaryTreePathsDo(root.left, path, ret)
        path = path_temp
        if root.right:
            self.binaryTreePathsDo(root.right, path, ret)



