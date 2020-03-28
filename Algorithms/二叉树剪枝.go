/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func pruneTree(root *TreeNode) *TreeNode {
	if(root == nil) {
		return nil
	}
    root.Left = pruneTree(root.Left)
	root.Right = pruneTree(root.Right)
	if(root.Left == nil && root.Right == nil) {
		if(root.Val == 1) {
			return root
		} else {
			return nil
		}
	}
    return root
}