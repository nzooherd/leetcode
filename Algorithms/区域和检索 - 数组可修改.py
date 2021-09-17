class SegementTreeNode:
    def __init__(self, start, end, sum_val, left=None, right=None):
        self.start = start
        self.end = end
        self.sum_val = sum_val
        self.left = left
        self.right = right

    def updateTree(self, index, val):
        if self.start == self.end and self.start == index:
            self.sum_val = val
            return
        mid = (self.start + self.end) // 2
        if mid >= index:
            self.left.updateTree(index, val)
        else:
            self.right.updateTree(index, val)
        self.sum_val = self.left.sum_val + self.right.sum_val

    def queryRange(self, start, end):
        if self.start == start and self.end == end:
            return self.sum_val
        mid = (self.start + self.end) // 2
        if mid >= end:
            return self.left.queryRange(start, end)
        elif start > mid:
            return self.right.queryRange(start, end)
        else:
            return self.left.queryRange(start, mid) + self.right.queryRange(mid+1, end)

def buildTree(nums, start, end):
    if start == end:
        return SegementTreeNode(start, end, nums[start])
    mid = (start + end) // 2
    left = buildTree(nums, start, mid)
    right = buildTree(nums, mid+1, end)
    return SegementTreeNode(start, end, left.sum_val + right.sum_val, left, right)


class NumArray:

    def __init__(self, nums: List[int]):
        if not nums:
            self.root = None
            return
        self.root = buildTree(nums, 0, len(nums) - 1)

    def update(self, i: int, val: int) -> None:
        self.root.updateTree(i, val)

    def sumRange(self, i: int, j: int) -> int:
        return self.root.queryRange(i, j)




# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(i,val)
# param_2 = obj.sumRange(i,j)