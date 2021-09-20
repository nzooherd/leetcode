class Solution {
    fun sumOfBeauties(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0;
        }

        val results = mutableListOf<Int>()
        for (i in 0..nums.size - 2) {
            results.add(0)
        }

        val maxValues = mutableListOf<Int>()
        var max = Int.MIN_VALUE
        for (i in nums.indices) {
            maxValues.add(max)
            if (nums[i] > max ) {
                max = nums[i]
            }
        }

        val minValues = mutableListOf<Int>()
        var min = Int.MAX_VALUE
        for (i in nums.size -1 downTo 0) {
            minValues.add(min)
            min = min.coerceAtMost(nums[i])
        }
        minValues.reverse()

        for (i in 1 until nums.size - 1) {
            if (nums[i] > maxValues[i] && nums[i] < minValues[i]) {
                results.add(2)
            } else if (nums[i] > nums[i-1] && nums[i] < nums[i + 1]) {
                results.add(1)
            } else {
                results.add(0)
            }
        }
        return results.sum()
    }
}