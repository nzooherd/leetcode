# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def nextLargerNodes(self, head):
        """
        :type head: ListNode
        :rtype: List[int]
        """
        index_result_map = {}

        result = []
        stack = []
        nums = []
        index = 0
        point = head
        if not point:
            return result
        while point:
            nums.append(point.val)
            point = point.next

        for index in range(len(nums)):
            if not stack:
                stack.append(index)
                continue

            value = nums[index]
            while stack and value > nums[stack[-1]]:
                index_result_map[stack.pop()] = value
            stack.append(index)
        for i in range(len(nums)):
            result.append(index_result_map.get(i, 0))
        return result