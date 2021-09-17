class Solution {
    fun getConcatenation(nums: IntArray): IntArray = nums
        .toList()
        .toMutableList()
        .also { it.addAll(nums.toList()) }
        .toIntArray()
            
}