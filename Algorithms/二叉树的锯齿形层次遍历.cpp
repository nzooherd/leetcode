/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
          void swap(vector<int>& a,int l){
            int i,temp;
            for(i=0;i<l/2;i++){
                temp=a[i];
                a[i]=a[l-i-1];
                a[l-i-1]=temp;
            }
        }

    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
    int flag=0;
            vector<vector<int>  > r;
            if(!root) return r;
            queue<TreeNode *> Q;
            Q.push(root);
            while(!Q.empty()){
                int size=Q.size();
                vector<int> level;
                for(int i=0;i<size;i++){
                    TreeNode *head=Q.front();Q.pop();
                    level.push_back(head->val);
                    if(head->left) Q.push(head->left);
                    if(head->right) Q.push(head->right);
                }
                if(flag%2) swap(level,size);
                flag++;
                r.push_back(level);
            }
            return r;



        
    }
};