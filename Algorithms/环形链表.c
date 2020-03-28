/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
bool hasCycle(struct ListNode *head) {
	struct ListNode *p1,*p2;
	p1=head;p2=head;
	while(p1&&p2){
		p1=p1->next;
		p2=p2->next;
		if(!p2) return 0;
		p2=p2->next;
		if(p1==p2) return 1;
	}
	return 0;



    
}