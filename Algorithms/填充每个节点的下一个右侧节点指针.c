/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  struct TreeLinkNode *left, *right, *next;
 * };
 *
 */
 typedef struct TreeLinkNode node;
void connect(struct TreeLinkNode *root) {
	node *p=root,*temp=NULL;
	if(!root) return;
	root->next=NULL;
	while(p){
		if(!temp) temp=p->left;
		if(p->left) p->left->next=p->right;
		if(p->right&&p->next) p->right->next=p->next->left;
		if(p->right&&!p->next) p->right->next=NULL;
		if(p->next) {
			p=p->next;
		}
		else {
			printf("%d\n",p->val);
			p=temp;
			temp=NULL;
		}
	}
    
}