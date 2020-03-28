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
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		if(root == null) return ans;
		search(root, ans, 1);
		return ans;
	}
	public void search(TreeNode root, List<Integer> ans, int k) {
		if(root == null) return;
		if(k > ans.size()) ans.add(root.val);
		if(root.right != null) search(root.right, ans, k+1);
		if(root.left != null) search(root.left, ans, k+1); 
	}
}