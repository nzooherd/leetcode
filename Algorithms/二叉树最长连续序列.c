/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

void recrusionSearch(struct TreeNode* root, int* res, int par_res, int par_val){
	if(!root){
		return;
	}
	int cur_res = 1;
	if(root->val == par_val + 1){
		cur_res += par_res;
	}
	if(cur_res > *res){
		*res = cur_res;
	}
	recrusionSearch(root->left, res, cur_res, root->val);
	recrusionSearch(root->right, res, cur_res, root->val);
}


int longestConsecutive(struct TreeNode* root){
	if(!root){
		return 0;
	}
	int res = 0;
	recrusionSearch(root, &res, 0, root->val - 1);
	return res;
}