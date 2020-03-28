/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 typedef struct  ListNode* Nt;
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
   short a[10000],b[10000],c[10000],i,j,k;
	memset(a,0,sizeof(a));memset(b,0,sizeof(b));memset(c,0,sizeof(c));
	Nt t,p,h;
	h=(Nt)malloc(sizeof(struct ListNode));
	h->next=NULL;h->val=0;
	p=h;i=0;j=0;
	while(l1!=NULL){
		a[i]=l1->val;
		i++;
		l1=l1->next;
	}
	while(l2!=NULL){
		b[j]=l2->val;
		j++;
		l2=l2->next;
	}
	for(k=0;k<(i>=j?i:j);k++){
		c[k]+=(a[k]+b[k]);
		c[k+1]+=(c[k])/10;
		c[k]=c[k]%10;
	}
	if(c[k]) k++;
	for(i=0;i<k;i++){
		t=(Nt)malloc(sizeof(struct ListNode));
		t->next=NULL;
		t->val=c[i];
		p->next=t;
		p=t;
	}
	return h->next;
    
}