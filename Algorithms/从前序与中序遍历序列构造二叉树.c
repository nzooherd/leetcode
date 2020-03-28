/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 typedef struct TreeNode Node;
struct TreeNode* buildTree(int* preorder, int preorderSize, int* inorder, int inorderSize) {
    	int i,j=0;
	Node* root=NULL;
	if(!preorderSize) return root;
	root=(Node*)malloc(sizeof(Node));
	for(i=0;i<inorderSize;i++)
		if(inorder[i]==preorder[0]) break;	
	root->val=preorder[0];
	root->left=buildTree(preorder+1,i,inorder,i);
	root->right=buildTree(preorder+i+1,preorderSize-i-1,inorder+i+1,inorder-i-1);
	return root;
    
}