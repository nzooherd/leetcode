# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def dfs(self, root, horizon_index, height, result):
        result[horizon_index].append((root.val, height))
        if root.left:
            self.dfs(root.left, horizon_index - 1, height + 1, result)
        if root.right:
            self.dfs(root.right, horizon_index + 1, height + 1, result)

    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        result = collections.defaultdict(list)
        if not root:
            return []
        self.dfs(root, 0, 1, result)
        items =  [_[1] for _ in sorted(result.items(), key= lambda x:x[0])]
        for i in range(len(items)):
            item = items[i]
            items[i] = [_[0] for _ in sorted(item, key=lambda x:x[1])]

        return items