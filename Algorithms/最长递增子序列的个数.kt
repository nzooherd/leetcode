class Solution {
    fun findNumberOfLIS(nums: IntArray): Int {
        val saveNum = nums.clone()

        nums.sort()
        var index = 1
        val discretizationMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            discretizationMap[num] = index++
        }

        val bit = BIT(index)
        for (num in saveNum) {
            val curIndex = discretizationMap[num]!!
            val previous = bit.sumOf(curIndex-1)
            if (previous.first == 0) {
                bit.update(curIndex, 1, 1)
            } else {
                bit.update(curIndex, previous.first + 1, previous.second)
            }
        }

        return bit.sumOf(index-1).second
    }
}

class BIT(var size: Int) {

    val values = MutableList(size) { Pair(0, 0) }

    fun lowBit(index: Int) : Int {
        return index and (-index)
    }

    fun sumOf(index: Int) : Pair<Int, Int>{
        var result = Pair(0, 0)
        var varIndex = index
        while (varIndex > 0) {
            if (values[varIndex].first > result.first) {
                result = values[varIndex]
            } else if (values[varIndex].first == result.first) {
                result = Pair(result.first, result.second + values[varIndex].second)
            }
            varIndex -= lowBit(varIndex)
        }
        return result
    }

    fun update(index: Int, value: Int, num: Int) {
        var varIndex = index
        while (varIndex < size) {
            if (values[varIndex].first < value) {
                values[varIndex] = Pair(value, num)
            } else if (values[varIndex].first == value) {
                values[varIndex] = Pair(value, values[varIndex].second + num)
            }
            varIndex += lowBit(varIndex)
        }
    }

}
