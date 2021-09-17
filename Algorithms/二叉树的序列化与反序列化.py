# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
import json

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        def serializeToList(root):
            if not root:
                return None
            res = []
            res.append(serializeToList(root.left))
            res.append(root.val)
            res.append(serializeToList(root.right))
            return res

        items = serializeToList(root) 
        return json.dumps(items) 


    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def deserializeFromList(items):
            if not items:
                return None

            node = TreeNode(items[1])
            node.left = deserializeFromList(items[0])
            node.right = deserializeFromList(items[2])
            return node

        return deserializeFromList(json.loads(data))

        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))