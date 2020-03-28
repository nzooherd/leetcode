/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
void print(struct TreeNode* root,int *r,int *k)
{
	if(root){
		print(root->left,r,k);
		r[(*k)++]=root->val;
		print(root->right,r,k);
	}

}
int* inorderTraversal(struct TreeNode*root,int *returnSize)
{
	int *r,k=0,i;
	r=(int*)malloc(sizeof(int)*100000);
	for(i=0;i<100000;i++) r[i]=0;
	print(root,r,&k);
	*returnSize=k;
	return r;
}