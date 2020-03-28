/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 typedef struct TreeNode Node;
struct TreeNode* buildTree(int* inorder, int inorderSize, int* postorder, int postorderSize) {
	int i,j=0;
	Node* root=NULL;
	if(!inorderSize) return root;
	root=(Node*)malloc(sizeof(Node));
	for(i=0;i<inorderSize;i++)
		if(inorder[i]==postorder[postorderSize-1]) break;	
	root->val=postorder[postorderSize-1];
	root->right=buildTree(inorder+i+1,inorderSize-i-1,postorder+i,inorderSize-i-1);
	root->left=buildTree(inorder,i,postorder,i);
	return root;


}