#
# @lc app=leetcode.cn id=114 lang=python
#
# [114] 二叉树展开为链表
#
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if not root:
            return 
        self.flattenDo(root)
        
    def flattenDo(self, root):
        if not root.left and not root.right:
            return root, root
        left_head, left_tail, right_head, right_tail = None, None, None, None
        if root.left:
            left_head, left_tail = self.flattenDo(root.left)
        if root.right:
            right_head, right_tail = self.flattenDo(root.right)
        
        head, tail = root, root
        if left_head:
            root.right = left_head
            left_tail.right = right_head
        
        if right_tail:
            tail = right_tail
        else:
            tail = left_tail
        root.left = None
        return head, tail



            

