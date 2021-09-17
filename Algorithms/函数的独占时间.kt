import java.util.*

class Solution {
    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val nCostMap = mutableMapOf<Int, Int>()
        val stack = LinkedList<Triple<Int, Int, Int>>()

        for (log in logs) {
            val items = log.split(":")
            val time = items[2].toInt()
            if (items[1] == "start") {
                stack.addLast(Triple(items[0].toInt(), time, 0))
            } else {
                var last = stack.pollLast()
                val virtualCost = time - last.second + 1
                val thisCost = time - last.second - last.third + 1
                nCostMap[last.first] = nCostMap.getOrDefault(items[0].toInt(), 0) + thisCost
                if (!stack.isEmpty()) {
                    last = stack.pollLast()
                    val newTriple = Triple(last.first, last.second, last.third + virtualCost)
                    stack.addLast(newTriple)
                }
            }
        }

        return IntRange(1, n).map { nCostMap.getOrDefault(it - 1, 0) }.toIntArray()
    }
}