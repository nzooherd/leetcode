# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def bstToGstDo(self, root, result):
        if root.right:
            self.bstToGstDo(root.right, result)
        root.val = result[0] + root.val
        result[0] = root.val
        if root.left:
            self.bstToGstDo(root.left, result)

    def bstToGst(self, root: TreeNode) -> TreeNode:
        if not root:
            return root
        self.bstToGstDo(root, [0])
        return root