/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 typedef struct ListNode Node;
typedef Node * node;
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
   node p,p1,p2,p_;
	p1=l1;p2=l2;p=NULL;	
	if(p1||p2){
		p_=(node)malloc(sizeof(Node));
		p=p_;
		p->next=NULL;
		if(p1&&p2&&p1->val<=p2->val||!p2){
			p_->val=p1->val;
			p1=p1->next;
		}
		else{
			p_->val=p2->val;
			p2=p2->next;
		}
	}
	while(p1||p2){
		if(p2==NULL||p1&&p2&&p1->val<=p2->val){
			p_->next=(node)malloc(sizeof(Node));
			p_=p_->next;
			p_->val=p1->val;
			p_->next=NULL;
			p1=p1->next;
		}
		else{
			p_->next=(node)malloc(sizeof(Node));
			p_=p_->next;
			p_->val=p2->val;
			p_->next=NULL;
			p2=p2->next;
		}
	}
	return p;
    
}