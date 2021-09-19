/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var prev: Node? = null
 *     var next: Node? = null
 *     var child: Node? = null
 * }
 */
class Solution {
    fun flatten(root: Node?): Node? {
        if (root == null) {
            return null
        }
        return flattenDo(root).first

    }

    fun flattenDo(root: Node?): Pair<Node?, Node?> {
        if (root == null) {
            return Pair(null, null)
        }

        val nextFlatten = flattenDo(root.next)
        var head = nextFlatten.first
        var tail = nextFlatten.second
        if (root.child != null) {
            val childFlatten = flattenDo(root.child)
            childFlatten.second!!.next = nextFlatten.first
            nextFlatten.first ?.let { it.prev = childFlatten.second }
            head = childFlatten.first!!
            if (tail == null) {
                tail = childFlatten.second
            }
            root.child = null
        }
        root.next = head
        head ?. let { it.prev = root }

        return Pair(root, tail ?: root)
    }
}