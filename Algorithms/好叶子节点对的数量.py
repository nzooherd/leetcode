# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def recrusionCount(self, root, res, height, distance):
        if not root.left and not root.right:
            return [height]

        left_leafs, right_leafs = None, None
        leafs = []
        if root.left:
            left_leafs = self.recrusionCount(root.left, res, height + 1, distance)
            leafs.extend(left_leafs)
        if root.right:
            right_leafs = self.recrusionCount(root.right, res, height + 1, distance)
            leafs.extend(right_leafs)
        if not left_leafs or not right_leafs:
            return leafs
        else:
            leafs.sort()

        distance += 2 * height
        left_index, right_index = 0, len(right_leafs) - 1
        for left_leaf_height in left_leafs:
            while(right_index > -1 and right_leafs[right_index] + left_leaf_height > distance):
                right_index -= 1
            res[0] += right_index + 1 
        return leafs


    def countPairs(self, root: TreeNode, distance: int) -> int:
        if not root:
            return 0
        res = [0]
        leafts = self.recrusionCount(root, res, 0, distance)
        return res[0]

