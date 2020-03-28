/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 int issame(struct TreeNode*p,struct TreeNode *q)
{
	int r=0;
	if(p&&q){
		if(p->val==q->val);
		else r++;
		r+=(issame(p->left,q->left)+issame(p->right,q->right));
	}
	else if(p&&!q) r++;
	else if(!p&&q) r++;
	else ;
	return r;
}
bool isSameTree(struct TreeNode* p, struct TreeNode* q) {
    int r;
	r=issame(p,q);
	return !r;

}