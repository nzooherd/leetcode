class Solution {
    fun reversePairs(nums: IntArray): Int {
        val saveNums =  nums.clone()
        nums.sort()

        var index = 1
        val discretizeMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            discretizeMap[num] = index++
        }

        var result = 0
        val bit = BIT(index+1)
        for (num in saveNums) {
            val value =  discretizeMap[num]!!
            result += bit.query(index) - bit.query(value)
            println(result)
            bit.update(value, 1)
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
