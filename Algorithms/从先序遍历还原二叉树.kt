class Solution {
    fun recoverFromPreorder(traversal: String): TreeNode? {
        if (traversal.isBlank()) {
            return  null
        }
        val result = recoverFromPreorder(traversal, 0, 0)
        return result.first
    }

    fun recoverFromPreorder(traversal: String, start: Int, level: Int): Pair<TreeNode?, Int> {
        if (start + level >= traversal.length) {
            return Pair(null, start - 1)
        }
        if (traversal.substring(start, start + level) != "-".repeat(level)) {
            return Pair(null, start - 1)
        }
        var valueIndex = traversal.indexOf('-', start + level)
        if (valueIndex == -1) {
            valueIndex = traversal.length
        }
        val root = TreeNode(Integer.parseInt(traversal.substring(start + level, valueIndex)))
        var end = valueIndex
        if (valueIndex != traversal.length) {
            val leftResult = recoverFromPreorder(traversal, valueIndex, level + 1)
            root.left = leftResult.first
            val rightResult = recoverFromPreorder(traversal, leftResult.second + 1, level + 1)
            root.right = rightResult.first
            valueIndex = rightResult.second
        }
        return Pair(root, valueIndex)
    }
}