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
    private var firstError : Int? = null
    private var secondError : Int? = null
    private var lastVal : Int? = null

    fun recoverTree(root: TreeNode?): Unit {
        if (root == null) {
            return
        }
        mediumIterator(root)
        changeVal(root)
    }

    fun mediumIterator(root: TreeNode){
        root.left ?.let { mediumIterator(it) }
        if (lastVal != null && root.`val` < lastVal!! && firstError == null) {
            firstError = lastVal
        }
        if (lastVal != null && root.`val` < lastVal!!) {
            secondError = root.`val`
        }
        lastVal = root.`val`
        root.right ?.let { mediumIterator(it) }
    }

    fun changeVal(root: TreeNode) {
        root.left ?.let { changeVal(it) }
        if (root.`val` == firstError) {
            root.`val` = secondError!!
        } else {
            if (root.`val` == secondError) {
                root.`val` = firstError!!
            }
        }
        root.right ?.let { changeVal(it) }
    }
}