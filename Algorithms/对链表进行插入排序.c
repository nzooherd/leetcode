/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* insertionSortList(struct ListNode* head) {
	int *r,k=0,i=0,temp=0,j;
	struct ListNode *p;
	p=head;
	while(p){
		p=p->next;
		k++;
	}
	r=(int*)malloc(sizeof(int)*(k+1));
	p=head;k=0;
	while(p){
		r[k++]=p->val;
		p=p->next;
	}	
	for(i=1;i<k;i++){
		temp=r[i];
		for(j=i-1;j>=0&&r[j]>temp;j--){
			r[j+1]=r[j];
		}
		r[j+1]=temp;
	}
	p=head;
	k=0;
	while(p){
		p->val=r[k++];
		p=p->next;
	}
	return head;
    
}