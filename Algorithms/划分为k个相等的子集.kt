class Solution {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        if (nums.sum() % k != 0) {
            return false
        }
        val kSum = nums.sum() / k
        val length = 1 shl nums.size
        val indexes = Array(length) {false}
        val oneCollection = mutableSetOf<Int>()
        for (index in 1 until length) {
            val sum = sumOfBits(index, nums)
            if ( sum % kSum != 0) {
                continue
            }
            if ( sum == kSum) {
                indexes[index] = true
                oneCollection.add(index)
                continue
            }
            for (oneIndex in oneCollection) {
                if (index or oneIndex == index) {
                    if (indexes[index - oneIndex]) {
                        indexes[index] = true
                        break
                    }
                }
            }
        }
        
        return indexes[length - 1]
    }

    fun sumOfBits(num: Int, nums: IntArray) : Int {
        var varNum = num;
        var index = -1
        var result = 0
        while (varNum > 0) {
            index += 1
            if (varNum and 1 == 1) {
               result += nums[index]
            }
            varNum = varNum shr 1
        }
        return result
    }
}