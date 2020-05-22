# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodesDo(self, root: TreeNode, cur_max):
        if not root:
            return 0
        result = 0
        if cur_max <= root.val:
            result += 1

        if root.left:
            result += self.goodNodesDo(root.left, max(cur_max, root.left.val))
        if root.right:
            result += self.goodNodesDo(root.right, max(cur_max, root.right.val))
        return result

    def goodNodes(self, root: TreeNode) -> int:
        if not root:
            return 0
        return self.goodNodesDo(root, root.val)