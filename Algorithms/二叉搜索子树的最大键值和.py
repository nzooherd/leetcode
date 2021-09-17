# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Tuple

class Solution:

    def maxSumBST(self, root: TreeNode) -> int:
        sum_bsts = [0]
        self.recrusion_max_sum_bst(root, sum_bsts)
        return max(sum_bsts)

    def recrusion_max_sum_bst(self, root, sum_bsts): # min max sum
        if not root.left and not root.right:
            sum_bsts.append(root.val)
            return (root.val, root.val, root.val, True)
        
        is_bst = True
        left_sum, right_sum = 0,0 
        left_min, right_max = root.val, root.val
        if root.left:
            left_min, left_max, left_sum, left_is_bst = self.recrusion_max_sum_bst(root.left, sum_bsts)
            if not left_is_bst or left_max >= root.val:
                is_bst = False

        if root.right:
            right_min, right_max, right_sum, right_is_bst = self.recrusion_max_sum_bst(root.right, sum_bsts)
            if not right_is_bst or right_min <= root.val:
                is_bst = False
        
        if is_bst:
            sum_bsts.append(left_sum + right_sum + root.val)
            return (left_min, right_max, sum_bsts[-1], True)
        else:
            return (-1, -1, -1, False) 