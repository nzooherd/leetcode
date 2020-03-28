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
    public boolean isSubtree(TreeNode s, TreeNode t) {
		if(t == null) return true;
		if(s == null) return false;
		if(is(s,t)) return true;
		else{
			if(isSubtree(s.left,t)) return true;
			if(isSubtree(s.right,t)) return true;; 
		}
		return false;
    }
	public boolean is(TreeNode s, TreeNode t) {
		boolean flag = false;
		if(s == null && t ==null) return true;
		else if(s == null && t != null) return false;
		else if(s != null && t == null) return false;
		else{
			if(s.val != t.val) return false;
			else{
				if(!is(s.left,t.left)) return false;
				if(!is(s.right,t.right)) return false;
			}
		}
		return true;

	}
}