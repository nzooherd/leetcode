class Solution {
    fun countQuadruplets(nums: IntArray): Int {
        if (nums.size < 4) {
            return 0
        }
        val index2NumSum = mutableMapOf<Int, MutableMap<Int, Int>>()
        for (i in 1 until nums.size) {
            val sumCount : MutableMap<Int, Int> = if (i != 1) HashMap(index2NumSum[i - 1]!!) else mutableMapOf()
            for (j in 0 until i) {
                val sum = nums[i] + nums[j]
                sumCount[sum] = 1 + sumCount.getOrDefault(sum, 0)
            }
            index2NumSum[i] = sumCount
        }

        var result = 0
        for (i in 3 until nums.size) {
            for (j in 2 until i) {
                val sumCount = index2NumSum[j - 1]!!
               result += sumCount.getOrDefault(nums[i] - nums[j], 0)
            }
        }
        return result
    }
}