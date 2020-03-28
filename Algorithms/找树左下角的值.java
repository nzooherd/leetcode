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
    public int findBottomLeftValue(TreeNode root) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int depth = 0, max = 0;
		search(root, depth, map);
		for(Map.Entry<Integer,Integer> temp : map.entrySet()) {
			max = Math.max(max,temp.getKey());
		}
		return map.get(max);
    }
	public void search(TreeNode root, int depth, HashMap<Integer,Integer> map) {
		if(root == null) return ;		
		if(!map.containsKey(depth)) {
			map.put(depth, root.val);
		}
		if(root.left != null) search(root.left, depth+1, map);
		if(root.right != null) search(root.right, depth+1, map);
	}
}