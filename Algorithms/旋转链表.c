/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* rotateRight(struct ListNode* head, int k) {
    if(!head) return head;
	int i, length = 1;
	struct ListNode *h, *p, *r;
	h = (struct ListNode*)malloc(sizeof(struct ListNode));
	p = (struct ListNode*)malloc(sizeof(struct ListNode));
	p = head;
	h = head;
	while(p->next){
		length++;
		p = p->next;
	}
    k %= length;
    if(length == 1|| k == 0|| k == length) return head;
    p->next = head;
	while(i++ < length - k - 1) {
		h = h->next;	
	}
	p = h->next;
	h->next = NULL;
	return p;

}