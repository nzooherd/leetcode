# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def splitListToParts(self, root: ListNode, k: int) -> List[ListNode]:
        result = []

        size = 0
        p = root
        while(p != None):
            size += 1
            p = p.next
        p = root
        
        numbers = [int(size / k) + 1] * (size % k) + [int(size / k)] * (k - (size % k))

        result.append(p)
        for number in numbers:
            index = 0
            while(index < number):
                index += 1            
                if index == number:
                    pre = p
                    p = p.next
                    pre.next = None
                else:
                    p = p.next

            result.append(p)
        
        return result[0:-1]