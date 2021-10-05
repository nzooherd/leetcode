class Codec {
    // Encodes a tree to a single string.
    fun encode(root: Node?): TreeNode? {
        if (root == null) {
           return null
        }
        val treeNode = TreeNode(root.`val`)
        if (root.children.isEmpty()) {
            return treeNode
        }
        val children = mutableListOf<TreeNode?>()
        for (child in root.children) {
            children.add(encode(child))
        }
        for (index in 0 until children.size - 1) {
            children[index] ?. let {
                it.right = children[index + 1]
            }
        }
        treeNode.left = children[0]
        return treeNode
    }

    // Decodes your encoded data to tree.
    fun decode(root: TreeNode?): Node? {
        if (root == null) {
            return null
        }
        val node = Node(root.`val`)
        if (root.left == null) {
            return node
        }

        val children = mutableListOf<Node?>()
        children.add(decode(root.left))
        var curTreeNode = root.left!!.right
        while (curTreeNode != null) {
            children.add(decode(curTreeNode))
            curTreeNode = curTreeNode.right
        }
        node.children = children
        return node
    }
}