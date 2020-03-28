/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
		if(root == null ) return 0;
		if(root.left == null && root.right == null) return 0;
		int ans = 0;
		if(root.left != null && root.left.left == null && root.left.right == null) ans += root.left.val;
		if(root.left != null) ans += sumOfLeftLeaves(root.left);
		if(root.right != null) ans += sumOfLeftLeaves(root.right);
		return ans;
    }
}