import heapq
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        pripoity_heap = []
        head = ListNode(0)
        p = head
        
        for node_index in lists:
            if node_index:
                heapq.heappush(pripoity_heap, (node_index.val, node_index))
        
        while len(pripoity_heap):
            next_node = heapq.heappop(pripoity_heap)[1]
            if next_node.next:
                heapq.heappush(pripoity_heap, (next_node.next.val, next_node.next))
            p.next = next_node
            p = p.next
        
        return head.next
