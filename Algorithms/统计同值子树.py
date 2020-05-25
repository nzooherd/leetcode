# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def countDo(self, root: TreeNode):
        if not root:
            return 0, False
        if root.left == None and root.right == None:
            return 1, True

        result, is_subtree = 0, False
        if root.left:
            left_count, left_is_subtree = self.countDo(root.left)
            result += left_count
            if not root.right and left_is_subtree and root.val == root.left.val:
                result += 1
                is_subtree = True

        if root.right:
            right_count, right_is_subtree = self.countDo(root.right)
            result += right_count
            if not root.left and right_is_subtree and root.val == root.right.val:
                result += 1
                is_subtree = True

        if root.left and root.right:
            if left_is_subtree and right_is_subtree and root.val == root.right.val and root.val == root.left.val:
                result += 1
                is_subtree = True

        return result, is_subtree


    def countUnivalSubtrees(self, root: TreeNode) -> int:
        result, _ = self.countDo(root)
        return result
