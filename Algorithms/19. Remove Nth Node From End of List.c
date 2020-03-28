/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
   int i,k=0;
	struct ListNode * p;
	p=head;
	while(p->next!=NULL){
		k++;
		p=p->next;
	}
    p=head;
	if(!(k+1-n)) head=head->next;
	else{
		for(i=0;i<(k-n);i++)
			p=p->next;
		p->next=p->next->next;
	}
	return head;	
    
}