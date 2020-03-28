func increasingBST(root *TreeNode) *TreeNode {
	head, _ := recursionReturn(root)
	return head

}
func recursionReturn(root *TreeNode) (*TreeNode, *TreeNode) {
	if root == nil || (root.Left == nil && root.Right == nil) {
		return root, root
	}
	leftHead, leftTail := recursionReturn(root.Left)
	rightHead, rightTail := recursionReturn(root.Right)

	root.Left = nil
	root.Right = rightHead
	if leftHead != nil {
		leftTail.Right = root
		if rightHead == nil {
			return leftHead, root
		} else {
			return leftHead, rightTail
		}
	} else {
		return root, rightTail
	}

}