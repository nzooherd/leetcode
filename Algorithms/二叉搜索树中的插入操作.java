/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void insertBST(TreeNode root, int val){

        if (val > root.val) {
            if (root.right != null){
                insertBST(root.right, val);
            }else{
                root.right = new TreeNode(val);
            }
        }else{
            if(root.left != null) {
                insertBST(root.left, val);
            }else{
                root.left = new TreeNode(val);
            }
        }

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            root = new TreeNode(val);
            return root;
        }
        insertBST(root, val);
        return root;

    }
}