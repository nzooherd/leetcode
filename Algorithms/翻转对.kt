class Solution {
    fun reversePairs(nums: IntArray): Int {
        val saveNums =  nums.clone()

        val sortNums = nums.toMutableList().map { it.toLong() }.toMutableList()
        for (num in saveNums) {
            sortNums.add(2 * num.toLong())
        }
        sortNums.sort()

        var index = 1
        val discretizeMap = mutableMapOf<Long, Int>()
        for (i in sortNums.indices) {
            discretizeMap[sortNums[i]] = index++
        }

        var result = 0
        val bit = BIT(index + 1)
        saveNums.forEachIndexed{ i, value: Int->
            result += i - (bit.query(discretizeMap[2 * value.toLong()]!!))
            bit.update(discretizeMap[value.toLong()]!!, 1)
        }

        return result
    }
}

class BIT(size: Int) {

    private val tree : Array<Int> = Array(size) {0}

    fun lowBit(num: Int) : Int {
        return num and (-num)
    }

    fun query(n: Int) : Int {
        var varN = n
        var result = 0
        while (varN > 0) {
            result += tree[varN]
            varN -= lowBit(varN)
        }
        return result
    }

    fun update(index: Int, num: Int) {
        var varIndex = index
        while (varIndex < tree.size) {
            tree[varIndex] += num
            varIndex += lowBit(varIndex)
        }
    }

}
