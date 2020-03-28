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
    public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return null;
		if(root.val == key) {
			if(root.left == null) return root.right;
			TreeNode q = searchleaf(root.left);
			q.right = root.right;
			return root.left;
		}
		TreeNode p = search(root,key);
		if(p == null) return root;
		if(p.left != null && p.left.val == key) {
			if(p.left.left == null) {
				p.left = p.left.right;
				return root;
			}
			TreeNode q = searchleaf(p.left.left);
			q.right = p.left.right;
			p.left = p.left.left;
			return root;
		}
		else {
			if(p.right.left == null) {
				p.right = p.right.right;
				return root;
			}
			TreeNode q = searchleaf(p.right.left);
			q.right = p.right.right;
			p.right = p.right.left;
			return root;
		}
    }
	public TreeNode search(TreeNode root,int key) {
	    if(root == null) return null;
		if(root.val > key) {
			if(root.left != null && root.left.val == key) return root;
			else return search(root.left,key);
		}
		else {
			if(root.right != null && root.right.val == key) return root;
			else return search(root.right,key);
		}
	}
	public TreeNode searchleaf(TreeNode root) {
		TreeNode temp = root;
		while(temp.right != null) {
			temp = temp.right;
		}
		return temp;

	}
}