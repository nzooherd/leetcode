"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
"""

class Solution:
    def inorderSuccessor(self, node: 'Node') -> 'Node':
        if not node:
            return None

        if node.right:
            next_node = node.right
            while(next_node.left):
                next_node = next_node.left
            return next_node

        if node.parent == None:
            return None 

        if node.parent.left == node:
            return node.parent

        parent = node.parent
        while(parent.left != node):
            node = parent
            parent = parent.parent
            if not parent:
                return None

        return parent

