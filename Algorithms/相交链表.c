/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
 	if(!headA || !headB) return NULL;
	struct ListNode *l1 = headA;
	struct ListNode *l2 = headB;
	while(l1 != l2) {
		l1 = l1 -> next;
		l2 = l2 -> next;
		if(l1 == l2) return l1;
		if(!l1) l1 = headB;
		if(!l2) l2 = headA;
	}
	return l1;
}