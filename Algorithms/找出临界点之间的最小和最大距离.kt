
class Solution {
    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        val mutuallyIndexes = mutableListOf<Int>()
        var index = 0
        var curNode = head
        var prefixValue: Int? = null
        while (curNode != null) {
            if (prefixValue != null) {
                val nextNode = curNode.next
                if (nextNode != null) {
                    if (curNode.`val` > prefixValue && curNode.`val` > nextNode.`val`) {
                        mutuallyIndexes.add(index)
                    }
                    if (curNode.`val` < prefixValue && curNode.`val` < nextNode.`val`) {
                        mutuallyIndexes.add(index)
                    }
                }
            }
            prefixValue = curNode.`val`
            curNode = curNode.next
            index += 1
        }
        if (mutuallyIndexes.size < 2)  {
            return intArrayOf(-1, -1)
        }
        val minDistance = mutuallyIndexes
            .mapIndexed { i, _ ->  if (i== 0) Int.MAX_VALUE else mutuallyIndexes[i] - mutuallyIndexes[i-1] }
            .min()!!
        val maxDistance = mutuallyIndexes.last() - mutuallyIndexes[0]
        return intArrayOf(minDistance, maxDistance)
    }
}