# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def find(self, root, height, x):
        for child in [root.left, root.right]:
            if child:
                if child.val == x:
                    return height + 1, root.val
                child_height, child_parent = self.find(child, height + 1, x)
                if child_height != -1:
                    return child_height, child_parent
        return -1, 0
        
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        if root.val == x or root.val == y:
            return False
        x_height, x_parent = self.find(root, 1, x)
        y_height, y_parent = self.find(root, 1, y)
        if x_height == y_height and x_height != -1:
            return x_parent != y_parent
        return False