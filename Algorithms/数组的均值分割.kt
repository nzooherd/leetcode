class Solution {
    fun splitArraySameAverage(nums: IntArray): Boolean {
        if (nums.size == 1) {
            return false
        }
        val normalizeNums = nums.map { it * nums.size - (nums.sum()) }
        val leftNums= normalizeNums.subList(0, nums.size / 2)
        val rightNums = normalizeNums.subList(nums.size / 2, nums.size)

        val set1 = resultSets(leftNums)
        val set2 = resultSets(rightNums)
        if (leftNums.sum() == 0 || rightNums.sum() == 0) {
            return true
        }
        if (0 in set1 || 0 in set2 || -(leftNums.sum()) in set2 || -(rightNums.sum()) in set1) {
            return true
        }
        for (num in set1) {
            if (-num in set2) {
                return true
            }
        }
        return false
    }

    private fun resultSets(nums: List<Int>) : Set<Int> {
        val length = 1 shl nums.size
        val results = mutableSetOf<Int>()
        for (i in 1 until length - 1) {
            var tempI = i
            var sum = 0
            var index = 0
            while (tempI > 0) {
                if (tempI and 1 == 1) {
                    sum += nums[index]
                }
                index += 1
                tempI = tempI shr 1
            }
            results.add(sum)
        }
        return results
    }

}
