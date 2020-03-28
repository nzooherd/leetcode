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
    public int rob(TreeNode root) {
		if(root == null) return 0;
		else if(root.left == null && root.right == null) {
			root.val = root.val;
		} 
		else if(root.left == null && root.right != null) {
			rob(root.right);
			int max = root.val;
			if(root.right.left != null) max += root.right.left.val;
			if(root.right.right != null) max += root.right.right.val;
			root.val = Math.max(max,root.right.val);
		}		
		else if(root.left != null && root.right == null) {
			rob(root.left);
			int max = root.val;
			if(root.left.left != null) max += root.left.left.val;
			if(root.left.right != null) max += root.left.right.val;	
			root.val = Math.max(max,root.left.val);
		}
		else{
			int root_max = rob(root.left) + rob(root.right);
			int max = root.val;
			if(root.left.left != null) max += root.left.left.val;
			if(root.left.right != null) max += root.left.right.val;
			if(root.right.left != null) max += root.right.left.val;
			if(root.right.right != null) max += root.right.right.val;
			root.val = Math.max(root_max,max);
		}
				System.out.println(root.val);
		return root.val;
    }
}