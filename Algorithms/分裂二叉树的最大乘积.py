# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def recrusionCalcuateSum(self, root, node2sum_value):
        if not root:
            return
        left_val, right_val = 0, 0
        if root.left:
            self.recrusionCalcuateSum(root.left, node2sum_value)
            left_val = node2sum_value[root.left]
        if root.right:
            self.recrusionCalcuateSum(root.right, node2sum_value)
            right_val = node2sum_value[root.right]
        node2sum_value[root] = left_val + right_val + root.val
    
    def maxProduct(self, root: TreeNode) -> int:
        if not root:
            return 0
        node2sum_value = {}
        self.recrusionCalcuateSum(root, node2sum_value)
        sum_val = node2sum_value[root]
        node_sum_values = list(node2sum_value.values())
        node_sum_values.sort()

        max_val = -1
        for i in range(0, len(node_sum_values)):
            cur_val = (sum_val - node_sum_values[i]) * node_sum_values[i]
            if cur_val > max_val:
                max_val = cur_val
        return max_val % (int(pow(10, 9) + 7))


