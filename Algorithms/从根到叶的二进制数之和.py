# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumRootToLeaf(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        ret = [0] 
        self.rec_sum_root(root, 0, ret)
        return ret[0]

    def rec_sum_root(self, root, parent_num, ret):
        parent_num *= 2
        parent_num += root.val
        if not root.left and not root.right:
            value = parent_num
            value %= 1000000007
            ret[0] += value
            ret[0] %= 1000000007
        if root.left:
            self.rec_sum_root(root.left, parent_num, ret)
        if root.right:
            self.rec_sum_root(root.right, parent_num, ret)