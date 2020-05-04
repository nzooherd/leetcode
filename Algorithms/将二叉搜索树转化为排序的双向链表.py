"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

class Solution:
    def do(self, root):
        if root.left is None and root.right is None:
            return root, root

        head, tail = root, root
        if root.left != None:
            left_head, left_tail = self.do(root.left)
            left_tail.right = root
            root.left = left_tail
            head = left_head
        if root.right != None:
            right_head, right_tail = self.do(root.right)
            root.right = right_head
            right_head.left = root
            tail = right_tail

        return head, tail

    def treeToDoublyList(self, root): 
        if not root:
            return root
        head, tail = self.do(root)

        head.left = tail 
        tail.right = head

        return head