/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 void pt(struct TreeNode* root,int sum,int k,int *r)
{
	if(!(*r)&&root){
		k+=root->val;
		if(k==sum&&!root->left&&!root->right) (*r)=1;
		else{
			pt(root->left,sum,k,r);
			pt(root->right,sum,k,r);
		}
	}
}
bool hasPathSum(struct TreeNode* root, int sum) {
	int r=0,s=0,k=0;
	pt(root,sum,k,&r);
	return r;
}