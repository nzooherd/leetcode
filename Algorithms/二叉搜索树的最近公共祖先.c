/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* lowestCommonAncestor(struct TreeNode* root, struct TreeNode* p, struct TreeNode* q) {
	if(root == NULL) return NULL;
	struct TreeNode* ans = (struct TreeNode*)malloc(sizeof(struct TreeNode));
	ans = root;
	if(ans->val == p->val || ans->val == q->val) return ans;
	if(ans->val < p->val && ans->val < q->val) ans = lowestCommonAncestor(ans->right, p, q);
	else if(ans->val > p->val && ans->val > q->val) ans =  lowestCommonAncestor(ans->left, p, q);  
	return ans;
}