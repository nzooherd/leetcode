class Solution {
    fun countMaxOrSubsets(nums: IntArray): Int {
        val length = 1 shl nums.size

        var max = Integer.MIN_VALUE; var result = 0;

        for (i in 1 until length) {
            var num = i
            var orResult = 0; var index = 0
            while (num > 0) {
                if (num and 1 == 1) {
                   orResult  = orResult or nums[index]
                }
                num = num shr 1
                index += 1
            }
            if (orResult > max) {
                max = orResult
                result = 1
            } else if (orResult == max) {
                result += 1
            }
        }
        return result
    }

}