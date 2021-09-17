# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None



class Solution:
    def dfs(self, root, result):
        if not root:
            return 0
        left = self.dfs(root.left, result)
        right = self.dfs(root.right, result)
        if left + right + 1 > result[0]:
            result[0] = left + right + 1
        return max(left, right) + 1


    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        result = [0]
        self.dfs(root, result)
        return max(result[0] - 1, 0)
        