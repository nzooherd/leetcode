/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {

	private TreeNode root = null;
	private LinkedList<TreeNode> nodeList = new LinkedList<>();

    public CBTInserter(TreeNode root) {
    	this.root = root;
    	searchRoot(root);
    }

    public void searchRoot(TreeNode root){
    	if(root == null){
    		return;
    	}

    	LinkedList<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while(queue.size() != 0){
    		TreeNode curNode = queue.poll();
    		if(curNode.left == null || curNode.right == null){
    			nodeList.add(curNode);
    		}
    		if(curNode.left != null){
    			queue.add(curNode.left);
    		}
    		if(curNode.right != null){
    			queue.add(curNode.right);
    		}
    	}

    }

    public int insert(int v) {
    	TreeNode node = new TreeNode(v);
    	TreeNode parent = nodeList.getFirst();
    	if(parent.left == null){
    		parent.left = node;
    	} else{
    		parent.right = node;
    		nodeList.poll();
    	}
    	nodeList.add(node);
        return parent.val;
    }
    
    public TreeNode get_root() {
    	return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */