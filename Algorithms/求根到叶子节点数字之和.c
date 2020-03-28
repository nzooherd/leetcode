/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 void Sum(struct TreeNode* root,int*a,int *k,int temp)
{
	if(!root->left&&!root->right){
		a[*k]=(temp)*10+root->val;
		(*k)++;
	}
	else {
		temp=(temp)*10+root->val;
		if(root->left) Sum(root->left,a,k,temp);
		if(root->right) Sum(root->right,a,k,temp);	
	}
}
int sumNumbers(struct TreeNode* root) {\
	int sum=0,*a,i=0,j=0,k=0,temp=0;
	a=(int*)malloc(sizeof(int)*1000);
	if(root) Sum(root,a,&k,temp);
	for(i=0;i<k;i++)
		sum+=a[i];
	return sum;
    
}