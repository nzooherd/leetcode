/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


typedef struct res{
	int is_bst;
	int min;
	int max;
	int num;
} Res;

Res* recrusionSearch(struct TreeNode* root, int* res){
	Res* left_res = NULL;
    Res* right_res  = NULL;
	Res* cur_res = (Res*)malloc(sizeof(Res));
	memset(cur_res, 0, sizeof(Res));
	cur_res->is_bst = 1;
	cur_res->min = root->val;
	cur_res->max = root->val;
	cur_res->num = 1;

	if(root->left){
		left_res = recrusionSearch(root->left, res);
	}
	if(root->right){
		right_res = recrusionSearch(root->right, res);
	}

	if(left_res){
		if(!left_res->is_bst || left_res->max >= root->val){
			cur_res->is_bst = 0;
			cur_res->num = 0;
		}else{
			cur_res->num += left_res->num;
			cur_res->min = left_res->min;
		}
	}
	if(right_res){
		if(!right_res->is_bst || right_res->min <= root->val){
			cur_res->is_bst = 0;
			cur_res->num = 0;
		}else{
			cur_res->num += right_res->num;
			cur_res->max = right_res->max;
		}
	}
	if(cur_res->num > *res){
		*res = cur_res->num;
	}
	return cur_res;
}


int largestBSTSubtree(struct TreeNode* root){
	if(!root){
		return 0;
	}
	int res = 0;
	recrusionSearch(root, &res);
	return res;
}