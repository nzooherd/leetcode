/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverse(struct ListNode* head, int length, struct ListNode* tril)
{
	if(head == NULL || head->next == NULL) return head;
	struct ListNode *p = head, *q = head->next;
	p -> next = tril;
	int count = 1;
	while(count < length) {
	    if(q == NULL) break;
		struct ListNode* temp = q->next;
		q->next = p;
		p = q;
		q = temp;
		count++;
	}
	return p;
}
struct ListNode* reverseBetween(struct ListNode* head, int m, int n) {
   	struct ListNode *pre = (struct ListNode*)malloc(sizeof(struct ListNode));
   	struct ListNode *tril = (struct ListNode*)malloc(sizeof(struct ListNode));
   	pre = head;
   	tril = head;
   	for(int i = 0; i < n; i++) {
   		tril = tril -> next;
   	}
   	if(m == 1) return reverse(head, n-m+1, tril);
   	else {
   		for(int i = 0; i < m-2; i++) {
   			pre = pre -> next;	
   		}
   		pre -> next = reverse(pre->next, n-m+1, tril);
   		return head;
   	}
   	return head;

}
