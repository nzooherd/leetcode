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
    public boolean leafSimilar(TreeNode root1, TreeNode root2){
        LinkedList<Integer> leaves1 = new LinkedList<>();
        LinkedList<Integer> leaves2 = new LinkedList<>();
        searchLeaf(root1, leaves1);
        searchLeaf(root2, leaves2);
        if(leaves1.size() != leaves2.size()) return false;
        Iterator<Integer> iterator1 = leaves1.iterator();
        Iterator<Integer> iterator2 = leaves2.iterator();
        while(iterator1.hasNext()){
            if(iterator1.next() != iterator2.next()) {
                return false;
            }
        }
        return true;
    }
    public void searchLeaf(TreeNode root, LinkedList<Integer> leaves){
        if(root == null) return;
        if(root.left == null && root.right == null) {
            leaves.add(root.val);
        } else {
            searchLeaf(root.left, leaves);
            searchLeaf(root.right, leaves);
        }

    }
}