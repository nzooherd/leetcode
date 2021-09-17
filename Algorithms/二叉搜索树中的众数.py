# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findModeDo(self, root, result, tail_value):
        cur_value, cur_count, res_count = root.val, 1, 1
        if root.left:
            self.findModeDo(root.left, result, tail_value)

        if root.val == tail_value[0]:
            cur_count = tail_value[1] + 1

        if cur_count == tail_value[2]:
            result.append(root.val)
        if cur_count > tail_value[2]:
            while(len(result) > 0):
                result.pop()
            result.append(root.val)
            res_count = cur_count

        tail_value[0], tail_value[1], tail_value[2] = cur_value, cur_count, max(res_count, tail_value[2])
        if root.right:
            self.findModeDo(root.right, result, tail_value)


    def findMode(self, root: TreeNode) -> List[int]:
        result = []
        if not root:
            return result
        self.findModeDo(root, result, [None, 0, 0])
        return result
