# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def checkValid(self, val2num):
        odd_count = 0
        for i in range(9):
            if val2num[i] % 2 != 0:
                odd_count += 1
        return True if odd_count <= 1 else 0

    def pseudoDo(self, root, val2num):
        if not root:
            return 0
        val2num[root.val - 1] += 1
        if root.left == None and root.right == None:
            if self.checkValid(val2num):
                return 1
        result = 0
        if root.right != None:
            right_val2num = [_ for _ in val2num]
            result += self.pseudoDo(root.right, right_val2num)
        if root.left != None:
            left_val2num = [_ for _ in val2num]
            result += self.pseudoDo(root.left, left_val2num)
        return result

    def pseudoPalindromicPaths(self, root: TreeNode) -> int:
        val2num = [0] * 9
        return self.pseudoDo(root, val2num)
