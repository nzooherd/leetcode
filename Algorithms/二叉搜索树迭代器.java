/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    public BSTIterator(TreeNode root) {
        TreeNode p = root;
        while(p != null) {
            stack.addLast(p);
            p = p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = stack.pollLast();
        TreeNode q = p.right;
        while(q != null) {
            stack.addLast(q);
            q = q.left;
        }
        return p.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */