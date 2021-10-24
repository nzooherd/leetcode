class Solution {
    fun countHighestScoreNodes(parents: IntArray): Int {
        val parentChildrenMap = mutableMapOf<Int, MutableList<Int>>()
        val childParentMap = mutableMapOf<Int, Int>()
        for (i in parents.indices) {
            val children = parentChildrenMap.computeIfAbsent(parents[i]) { mutableListOf() }
            children.add(i)
            childParentMap[i] = parents[i]
        }

        val nodeCounts = calculateTreeNodeCounts(parentChildrenMap)

        var result: Int = 0
        var resultMax: Long = 0
        for (i in parents.indices) {
            var sum: Long = 1
            for (child in parentChildrenMap.getOrDefault(i, mutableListOf())) {
                sum *= nodeCounts[child]!!
            }
            if (i != 0 && childParentMap.containsKey(i)) {
                sum *= (nodeCounts[0]!! - nodeCounts[i]!!)
            }
            if (sum > resultMax) {
                resultMax = sum
                result = 1
            }else if (sum == resultMax) {
                result += 1
            }
        }
        return result
    }

    fun calculateTreeNodeCounts(parentChildrenMap: Map<Int, MutableList<Int>>):  MutableMap<Int, Int> {
        val result = mutableMapOf<Int, Int>()
        calculateDo(parentChildrenMap, 0, result)
        return result
    }

    fun calculateDo(parentChildrenMap: Map<Int, MutableList<Int>>, node: Int, result: MutableMap<Int, Int>) {
        if (!parentChildrenMap.containsKey(node)) {
            result[node] = 1
            return
        }
        var sum = 1
        for (child in parentChildrenMap[node]!!) {
            calculateDo(parentChildrenMap, child, result)
            sum += result[child]!!
        }
        result[node] = sum
        return
    }


}
