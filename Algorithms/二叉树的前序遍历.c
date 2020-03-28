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
 typedef struct TreeNode node;
void pr(node* root,int *r,int *k)
{
	if(root){
		r[*k]=root->val;(*k)++;
		pr(root->left,r,k);
		pr(root->right,r,k);
	}

}
int* preorderTraversal(struct TreeNode* root, int* returnSize) {
	int *r,k;
	r=(int*)malloc(sizeof(int)*10000);
	pr(root,r,&k);
	*returnSize=k;
	return r;
    
}