/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        val result = mutableListOf<TreeNode?>()
        delNodes(root, to_delete.toMutableSet(), result, true)
        return result.filterNotNull()
    }
    fun delNodes(root: TreeNode?, deleteSet: Set<Int>, result: MutableList<TreeNode?>, includeRoot: Boolean) {
        if (root == null) {
            return
        }
        if (includeRoot) {
            if (!deleteSet.contains(root.`val`)) {
                result.add(root)
            }
        }

        delNodes(root.left, deleteSet, result, deleteSet.contains(root.`val`))
        if (root.left != null && deleteSet.contains(root.left!!.`val`)) {
            root.left = null
        }
        delNodes(root.right, deleteSet, result, deleteSet.contains(root.`val`))
        if (root.right != null && deleteSet.contains(root.right!!.`val`)) {
            root.right = null
        }

    }
}