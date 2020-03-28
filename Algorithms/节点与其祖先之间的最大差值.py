# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxAncestorDiff(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        max_val = root.val
        min_val = root.val
        return self.reckon_max_margin(root, max_val, min_val)
        
    def reckon_max_margin(self, root, max_val, min_val):
        if not root:
            return 0
        max1 = max_val - root.val
        max2 = min_val - root.val
        if max1 < 0:
            max1 = -max1
        if max2 < 0:
            max2 = -max2
        max_margin = max(max1, max2)  
        if root.val > max_val:
            max_val = root.val
        if root.val < min_val:
            min_val = root.val
        if root.left:
            max_margin = max(max_margin, self.reckon_max_margin(root.left, max_val, min_val))
        if root.right:
            max_margin = max(max_margin, self.reckon_max_margin(root.right, max_val, min_val))
        return max_margin

