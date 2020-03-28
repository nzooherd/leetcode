# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def smallestFromLeaf(self, root):
        """
        :type root: TreeNode
        :rtype: str
        """
        letter_index = [0] * 26
        for i in range(0, 26):
            letter_index[i] = chr(i + 97)
        return self.min_sub_tree(root, "", letter_index)

    def min_sub_tree(self, root, parent_str, letter_index):
        parent_str += letter_index[root.val]
        min_left = None
        max_right = None
        if root.left:
            root.left = self.min_sub_tree(root.left, parent_str, letter_index) 
        if root.right:
            root.right = self.min_sub_tree(root.right, parent_str, letter_index)
        if not root.left and not root.right:
            return parent_str[::-1]
        else:
            return root.left if not root.right else (root.right if not root.left else min(root.left, root.right))

