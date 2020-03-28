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
    public static final int   MAX_VALUE = 0x7fffffff;
    public boolean isBalanced(TreeNode root) {
    	if(heigth(root) != MAX_VALUE) return true;
    	else return false;
    }
    public int heigth(TreeNode root) {
    	if(root == null) return -1;
    	else {
    		int heigthLeft = heigth(root.left), heigthRight = heigth(root.right);
    		if(heigthLeft == MAX_VALUE || heigthRight == MAX_VALUE) return MAX_VALUE;
    		if(heigthLeft - heigthRight > 1 || heigthLeft - heigthRight < -1) return MAX_VALUE;
    		else return Math.max(heigthLeft, heigthRight) + 1;
    	}

    }
}