class Solution {
    fun rearrangeArray(nums: IntArray): IntArray {
        nums.sort()
        val result = mutableListOf<Int>()
        for (i in 0 until (nums.size + 1) / 2 ) {
            result.add(nums[i])
            if (i + (nums.size + 1) / 2 < nums.size) {
                result.add(nums[i + (nums.size + 1) / 2])
            }
        }
        return result.toIntArray()
    }
}