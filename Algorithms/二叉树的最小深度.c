/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
void findMin(struct TreeNode* root,int *k,int depth)
{
	if(!root->left&&!root->right) {
		if(depth<(*k)||!(*k)) (*k)=depth;
	}
	if(root->left) findMin(root->left,k,depth+1);
	if(root->right) findMin(root->right,k,depth+1);
}
int minDepth(struct TreeNode* root) {
	int k=0,depth=1;
	if(!root) ;
	else findMin(root,&k,depth);
	return k;
}