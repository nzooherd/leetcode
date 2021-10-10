
class Solution {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val nums = mutableListOf<Int>()
        for (row in grid) {
            for (column in row) {
                nums.add(column)
            }
        }
        nums.sort()
        for (i in 1 until nums.size) {
            if ((nums[i] - nums[i - 1]) % x != 0) {
                return -1
            }
        }
        val flag = nums[nums.size / 2]
        var result = 0
        for (num in nums) {
            result += (kotlin.math.abs(num - flag) / x)
        }
        return result

    }
}