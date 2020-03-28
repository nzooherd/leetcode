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
	int height(TreeNode root) {
		return root == null ? -1 : 1 + height(root.right);
	}
	public int countNodes(TreeNode root) {
	    if(root == null) return 0;
		int h = height(root);
		if(h-1 == height(root.left)) return (1 << h) + countNodes(root.left);
		else return (1 << h+1) + countNodes(root.right);

	}
}