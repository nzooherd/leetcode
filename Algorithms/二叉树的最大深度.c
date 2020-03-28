/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 void search(struct TreeNode* root,int k,int *max)
{
	if(root){
		search(root->left,k+1,max);
		if(k>(*max)) (*max)=k;
		search(root->right,k+1,max);
	}
}
int maxDepth(struct TreeNode* root) {
	int max=0;
	search(root,1,&max);
	return max;
}