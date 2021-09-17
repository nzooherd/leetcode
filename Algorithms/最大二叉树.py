# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, nums, start, end, range2max_index):
        if start == end:
            return TreeNode(nums[start])
        
        max_val_index = range2max_index[(start, end)]
        root = TreeNode(nums[max_val_index])
        if max_val_index > start:
            root.left = self.buildTree(nums, start, max_val_index - 1, range2max_index)
        if max_val_index < end:
            root.right = self.buildTree(nums, max_val_index + 1, end, range2max_index)
        return root


    def constructMaximumBinaryTree(self, nums: List[int]) -> TreeNode:
        if not nums:
            return None

        range2max_index = {}
        for i in range(0, len(nums)):
            cur_max, cur_max_index = float('-inf'), -1
            for j  in range(i, len(nums)):
                if nums[j] > cur_max:
                    cur_max = nums[j]
                    cur_max_index = j
                range2max_index[(i, j)] = cur_max_index
        
        return self.buildTree(nums, 0, len(nums)-1, range2max_index)