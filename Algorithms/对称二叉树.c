/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
void search(struct TreeNode * rl,struct TreeNode *rr,int *r)
{
	if(rr&&rl){
		if(rl->val==rr->val);
		else (*r)++;
		search(rl->left,rr->right,r);
		search(rl->right,rr->left,r);	
	}
	else if(!rl&&!rr) ;
	else (*r)++;
}
bool isSymmetric(struct TreeNode* root) {
  int k=0;
	if(!root) return 1;
	search(root->left,root->right,&k);
	return (!k);
    
}