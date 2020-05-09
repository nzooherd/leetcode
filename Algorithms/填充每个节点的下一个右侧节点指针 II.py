"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next  
"""

class Solution:
    def do(self, root, current_height, height2node):
        if not root:
            return

        if current_height in height2node:
            root.next = height2node[current_height]
        height2node[current_height] = root

        self.do(root.right, current_height +1, height2node)
        self.do(root.left, current_height + 1, height2node)

    def connect(self, root: 'Node') -> 'Node':
        self.do(root, 1, {})
        return root