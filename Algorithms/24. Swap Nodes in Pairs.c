/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 typedef struct ListNode* Node;
struct ListNode* swapPairs(struct ListNode* head) {
  Node p;
	int i=0,temp;
	p=head;
	while(p!=NULL){
		if(!(i%2)){
		if(p->next){
		        temp=p->val;
				p->val=p->next->val;
				i++;p=p->next;
			}
			else{
				return head;
			}
		}
		else{
			p->val=temp;
			p=p->next;i++;
		}
	}
	return head;
    
}