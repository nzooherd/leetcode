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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(root == null) return ans;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int sum_temp = 0;
		dfs(root, sum, sum_temp, ans, temp);
		return ans;
    }
	public void dfs(TreeNode root, int sum, int sum_temp, List<List<Integer>> ans, ArrayList<Integer> temp) {
		if(root == null) ;
		else if(root.left == null && root.right == null && sum_temp + root.val == sum) {
			temp.add(root.val);
			ans.add(temp);		
		}
		else{
			if(root.left != null) {
				ArrayList<Integer> p = (ArrayList<Integer>)temp.clone();
				p.add(root.val);
				dfs(root.left, sum, sum_temp+root.val, ans, p);
			}
			if(root.right != null) {
				ArrayList<Integer> q = (ArrayList<Integer>)temp.clone();
				q.add(root.val);
				dfs(root.right, sum, sum_temp+root.val, ans, q);
			}
		}		
	}
}