/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
void pt(struct TreeNode* root,int *r,int *k)
{
	if(root){
		if(root->left){
			pt(root->left,r,k);
		}
		r[*k]=root->val;
		(*k)++;
		if(root->right){
			pt(root->right,r,k);
		}
	}
}
bool isValidBST(struct TreeNode* root) {
	int *r,k=0,s=1,i;
	r=(int*)malloc(sizeof(int)*30000);
	pt(root,r,&k);
	for(i=0;i<k-1;i++){
		if(r[i]>=r[i+1]){
			s=0;
			break;
		}
	}
	return s;
}