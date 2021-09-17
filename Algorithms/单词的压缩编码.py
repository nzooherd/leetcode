class TreeNode:
    def __init__(self, val):
        self.val = val
        self.children = {} 


class Solution:

    def recrusionTreeNode(self, root, height):
        if not root.children:
            return height + 1
        result = 0
        for key, node in root.children.items():
            result += self.recrusionTreeNode(node, height + 1)
        return result


    def minimumLengthEncoding(self, words: List[str]) -> int:
        root = TreeNode(None)
        for word in words:
            word = word[::-1]
            cur_node = root
            for char in word:
                if char not in cur_node.children:
                    next_node = TreeNode(char)
                    cur_node.children[char] = next_node
                cur_node = cur_node.children[char]

        nodes = self.recrusionTreeNode(root, 0)
        return nodes
