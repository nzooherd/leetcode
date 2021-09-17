class Solution {
    fun maxNonOverlapping(nums: IntArray, target: Int): Int {
        if(nums.isEmpty()){
            return 0
        }
        val sum2Index = mutableMapOf<Int, Int>()
        val index2Res = IntArray(nums.size)

        var curSum = 0
        var curRes = 0

        for((index, num) in nums.withIndex()){
            curSum += num
            val marginSum = curSum - target
            if(!sum2Index.containsKey(marginSum)){
                if(marginSum == 0 && curRes == 0){
                    curRes = 1
                }
                index2Res[index] = curRes
                sum2Index[curSum] = index
                continue
            }

            val lastResIndex = sum2Index[marginSum]!!
            if(index2Res[lastResIndex] + 1 > curRes){
               curRes = index2Res[lastResIndex] + 1
            }
            sum2Index[curSum] = index
            index2Res[index] = curRes
        }
        return index2Res[nums.size - 1]
    }
}