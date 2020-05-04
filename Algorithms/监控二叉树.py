# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def dfs_search(self, root, result):
        if not root:
            return 0, 0
        if not root.left and not root.right:
            return 1,   1
        if root in result:
            return result[root][0], result[root][1]

        current_value, not_current_value = 1001, 1001
        if root.left:
            current_left_sum = min(self.dfs_search(root.left.left, result)) + min(self.dfs_search(root.left.right, result))
            current_left_sum = min(current_left_sum, min(self.dfs_search(root.left, result)))
        else:
            current_left_sum = 0
        if root.right: 
            current_right_sum = min(self.dfs_search(root.right.left, result)) + min(self.dfs_search(root.right.right, result))
            current_right_sum = min(current_right_sum, min(self.dfs_search(root.right, result)))
        else:
            current_right_sum = 0
        current_value = current_left_sum + current_right_sum + 1

        if root.left:
            not_current_value = self.dfs_search(root.left, result)[0] + min(self.dfs_search(root.right, result))
        if root.right:
            not_current_value = min(self.dfs_search(root.right, result)[0] + min(self.dfs_search(root.left, result)), not_current_value)
        result[root] = (current_value, not_current_value) 
        return current_value, not_current_value
    def minCameraCover(self, root: TreeNode) -> int:
        result = {}
        return min(self.dfs_search(root, result))