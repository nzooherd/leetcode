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
    fun closestKValues(root: TreeNode?, target: Double, k: Int): List<Int> {
        val result = LinkedList<Int>()
        closetKValuesDo(root, target, k, result)
        return result
    }

    fun closetKValuesDo(root: TreeNode?, target: Double, k: Int, result: LinkedList<Int>) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            closetKValuesDo(root.left, target, k, result)
        }
        if (result.size < k) {
            result.addLast(root.`val`)
        } else {
           if (root.`val` <= target) {
               result.pollFirst()
               result.addLast(root.`val`)
           } else {
              if (root.`val` - target < Math.abs(target - result.first))  {
                  result.pollFirst()
                  result.addLast(root.`val`)
              } else {
                  return
              }
           }
        }
        closetKValuesDo(root.right, target, k ,result)
    }
}