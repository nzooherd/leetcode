# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preRange(self, root, p):
        first, last = root, root
        if root.left:
            left_first, left_last, find = self.preRange(root.left, p)
            if find:
                return left_first, left_last, find
            if left_last == p:
                return left_first, left_last, root
            first = left_first

        if root.right:
            right_first, right_last, find = self.preRange(root.right, p)
            if find:
                return right_first, right_last, find
            if root == p:
                return right_first, right_last, right_first
            last = right_last

        print(first.val, last.val)
        return first, last, None

    def inorderSuccessor(self, root: 'TreeNode', p: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        first, last, find = self.preRange(root, p)
        return find