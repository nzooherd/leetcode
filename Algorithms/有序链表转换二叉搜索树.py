# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def generate_bst(self, start_point, size):
        if size == 1:
            root = TreeNode(start_point.val)
            return root
        if size == 2:
            root = TreeNode(start_point.val)
            root.right = TreeNode(start_point.next.val)
            return root
        
        p = start_point
        left_length = int(size / 2)
        cur_index = 0
        while(cur_index < left_length):
            p = p.next
            cur_index += 1

        root = TreeNode(p.val)
        root.left = self.generate_bst(start_point, left_length)
        root.right = self.generate_bst(p.next, size - 1 - left_length)
        return root

    def sortedListToBST(self, head: ListNode) -> TreeNode:
        size = 0
        p = head
        while(p != None):
            p = p.next
            size += 1
        if head is None:
            return None
        return self.generate_bst(head, size)