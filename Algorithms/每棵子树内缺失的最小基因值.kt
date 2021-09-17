class Solution {
    private val indexResultMap = mutableMapOf<Int, Int>()

    fun smallestMissingValueSubtree(parents: IntArray, nums: IntArray): IntArray {
        val rootSubRootsMap = mutableMapOf<Int, MutableList<Int>>()
        for (index in parents.indices) {
            val parent = parents[index]
            val children = rootSubRootsMap.computeIfAbsent(parent) {mutableListOf()}
            children.add(index)
        }
        computeResult(0, nums, rootSubRootsMap)
        val result = mutableListOf<Int>()
        for (i in nums.indices) {
            result.add(indexResultMap[i]!!)
        }

        return result.toIntArray()
    }

    fun computeResult(root: Int, values: IntArray, parentChildrenMap: Map<Int, MutableList<Int>>) : MutableSet<Int> {
        val childrenValues = mutableSetOf<Int>().also { it.add(values[root]) }
        val children = parentChildrenMap[root]
        if (children == null) {
            indexResultMap[root] = if (values[root] != 1) 1 else 2
            return childrenValues
        }
        val allChildrenValues = mutableListOf<MutableSet<Int>>()
        allChildrenValues.add(childrenValues)
        for (child in children) {
            allChildrenValues.add(computeResult(child, values, parentChildrenMap))
        }
        allChildrenValues.sortBy { -it.size }
        for (i in 1 until allChildrenValues.size) {
            allChildrenValues[0].addAll(allChildrenValues[i])
        }

        val childrenMiss = children.map { indexResultMap[it]!! }
        val maxChildMiss = childrenMiss.max()!!
        var result = maxChildMiss
        while (allChildrenValues[0].contains(result)) {
            result += 1
        }
        indexResultMap[root] = result
        return allChildrenValues[0]
    }

}