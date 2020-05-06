# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def cal_width(self, root, current_height, current_h_index, width_dict):
        if not root:
            return 
        current_h_index %= int(pow(2, 32))
        if current_h_index < width_dict[current_height][0]:
            width_dict[current_height][0] = current_h_index
        if current_h_index > width_dict[current_height][1]:
            width_dict[current_height][1] = current_h_index

        self.cal_width(root.left, current_height + 1, current_h_index * 2 + 1, width_dict)
        self.cal_width(root.right, current_height + 1, current_h_index * 2 + 2, width_dict)

    def widthOfBinaryTree(self, root: TreeNode) -> int:
        if not root:
            return 1
        width_dict = collections.defaultdict(lambda : [int(pow(2, 32)), 0])
        self.cal_width(root, 1, 1, width_dict)
        result = 0
        for value in width_dict.values():
            result = max(result, value[1] - value[0]) 
        return result + 1