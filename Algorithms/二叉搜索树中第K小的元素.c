/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int kthSmallest(struct TreeNode* root, int k) {
	int* nums = (int*)malloc(sizeof(int)*100000);
	int i = 1;
	search(root,&i,nums);
	return nums[k];
}
void search(struct TreeNode* root, int *k, int* nums){
	if(root == NULL) return ;
	if(root->left != NULL) {
		search(root->left,k,nums);
	}
	nums[*k] = root->val;
	(*k)++;
	if(root->right != NULL) 
		search(root->right,k,nums);

}
