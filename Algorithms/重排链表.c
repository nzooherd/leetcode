/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 typedef struct ListNode node;
void reorderList(struct ListNode* head) {
    if(!head||!head->next)
		return ;
	node *fast,*slow,*p1,*p2,*p_temp1,*p_temp2;
	fast=(node*)malloc(sizeof(node));
	slow=(node*)malloc(sizeof(node));
	fast=head;slow=head;
	while(fast->next&&fast->next->next){
		slow=slow->next;
		fast=fast->next->next;
	}
	fast=slow->next;
	slow->next=NULL;
	node *p,*p_,*temp;
	p=(node*)malloc(sizeof(node));
	p=fast->next;p_=fast;
	while(p){
		temp=p->next;
		p->next=fast;
		printf("%d\n",p->next->val);
		fast=p;
		p=temp;
	}
	p_->next=NULL;
	p=fast;
	while(p){
		printf("%d\n",p->val);
		p=p->next;
	}

	p1=head;p2=fast;
	while(p1&&p2){
		p_temp1=p1->next;
		p_temp2=p2;
		p2=p2->next;
		p1->next=p_temp2;
		p_temp2->next=p_temp1;
		p1=p1->next->next;
	}
    
}