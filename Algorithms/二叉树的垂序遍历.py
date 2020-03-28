# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def verticalTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        ret = [] 
        coordinates = {}
        self.rec_caculate_horizon(root, coordinates, 0, 0)
        for item in sorted(coordinates.items(), cmp=lambda x, y: cmp(x[0], y[0])):
            values_with_degree = item[1] 
            values_sorted = sorted(values_with_degree, cmp = lambda x, y : cmp(x[0], y[0]) if x[1] == y[1] else cmp(x[1], y[1]))
            values = [value[0] for value in values_sorted]
            ret.append(values)
        return ret

    def rec_caculate_horizon(self, root, coordinates, horizon, degree):
        if horizon not in coordinates:
            coordinates[horizon] = []
        coordinates[horizon].append((root.val, degree))
        if root.left:
            self.rec_caculate_horizon(root.left, coordinates, horizon - 1, degree + 1)
        if root.right:
            self.rec_caculate_horizon(root.right, coordinates, horizon + 1, degree + 1)


