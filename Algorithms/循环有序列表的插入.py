
# Definition for a Node.
class Node:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next


import sys

class Solution:
    def insert(self, head: 'Node', insertVal: int) -> 'Node':
        if head is None:
            head = Node(val=insertVal)
            head.next = head
            return head

        result = head
        cur, head, tail = head, None, None
        cur_val = cur.val
        min_val, max_val = float('inf'), float('-inf')
        while(True):
            if cur.val < min_val:
                min_val = cur.val
                head = cur
            if cur.val >= max_val:
                max_val = cur.val
                tail = cur
            if cur.val <= insertVal and cur.next.val > insertVal:
                node = Node(val=insertVal, next=cur.next)
                cur.next = node
                return result

            cur = cur.next
            if cur == result:
                break

        node = Node(val=insertVal, next=head)
        tail.next = node
        return result