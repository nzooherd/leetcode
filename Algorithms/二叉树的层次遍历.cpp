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
    vector<vector<int>> levelOrder(TreeNode* root) {
    vector<vector<int>> r;
      if(!root) return r;
      queue<TreeNode *>Q;
      Q.push(root);
      while(!Q.empty()){
          int size=Q.size();
          vector<int> level;
          for(int i=0;i<size;i++){
              TreeNode *head=Q.front();Q.pop();
              level.push_back(head->val);
              if(head->left){
                  Q.push(head->left);
              }
              if(head->right){
                  Q.push(head->right);
              }
        }
        r.push_back(level);
      }
      return r;

          

    }
};