# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def link_to_str(self, head):
        num_str = ''
        p = head
        while(p is not None):
            num_str += str(p.val)
            p = p.next
        
        return num_str
    
    def num_str_to_link(self, num_str):
        head = ListNode(0)
        p = head
        for num in num_str:
            node = ListNode(num)
            p.next = node 
            p = p.next
        return head.next

    def num_str_add_one(self, num_str: str):
        num_str = num_str[::-1]
        carry = False
        result = ""

        for i, bit_str in enumerate(num_str):
            bit = int(bit_str)
            if i == 0:
                bit += 1
            bit += 1 if carry else 0
            if bit >= 10:
                bit %= 10
                carry = True
            else:
                carry = False
            result += str(bit)
        
        if carry:
            result += "1"
        
        return result[::-1]

    def plusOne(self, head: ListNode) -> ListNode:
        if head is None:
            return None
        num_str = self.link_to_str(head)
        num_str = self.num_str_add_one(num_str)
        return self.num_str_to_link(num_str)
        
    