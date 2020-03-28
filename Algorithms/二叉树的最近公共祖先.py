#
# @lc app=leetcode.cn id=236 lang=python
#
# [236] 二叉树的最近公共祖先
#
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        ret, _, _ = self.lowestCommonAncestorDo(root, p, q)
        return ret
        
    def lowestCommonAncestorDo(self, root, p, q):
        if not root:
            return None, False, False
        is_p = (root.val == p.val)
        is_q = (root.val == q.val)
        if not root.left and not root.right:
            return None, is_p, is_q

        ret_left, left_has_p, left_has_q = self.lowestCommonAncestorDo(root.left, p, q)
        if ret_left:
            return ret_left, left_has_p or is_p, left_has_q or is_q
        ret_right, right_has_p, right_has_q = self.lowestCommonAncestorDo(root.right, p, q)
        if ret_right:
            return ret_right, right_has_p or is_p, right_has_q or is_q
        
        is_p = is_p or left_has_p or right_has_p
        is_q = is_q or left_has_q or right_has_q
        ret = None
        if is_p and is_q:
            ret = root
        return ret, is_p, is_q 

