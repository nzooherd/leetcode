/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] maxPathSum1(TreeNode root){
        int[] vals = new int[2];
        vals[0] = 0x80000000; vals[1] = 0x80000000;
        if(root == null) return null;
        if(root.left == null && root.right == null) {
            vals[0] = root.val;
            vals[1] = root.val;
        }
        else {
            int[] numsl = maxPathSum1(root.left);
            int[] numsr = maxPathSum1(root.right);

            if(numsl == null) {
               vals[0] = Math.max(numsr[0], numsr[1]);

               vals[1] = Math.max(root.val, numsr[1] + root.val);
            }
            else if(numsr == null) {

               vals[0] = Math.max(numsl[0], numsl[1]);

               vals[1] = Math.max(root.val, numsl[1] + root.val);

            }
            else {
                vals[0] = Math.max(numsl[0], numsr[0]);
                vals[0] = Math.max(vals[0], numsl[1]);
                vals[0] = Math.max(vals[0], numsr[1]);
                vals[0] = Math.max(numsl[1] + root.val + numsr[1], vals[0]);

                vals[1] = Math.max(root.val, numsl[1] + root.val);
                vals[1] = Math.max(vals[1], numsr[1] + root.val);
            }
        }
       return vals;
    }
    public int maxPathSum(TreeNode t) {
        int[] nums = maxPathSum1(t);
        return Math.max(nums[0], nums[1]);
    }
}