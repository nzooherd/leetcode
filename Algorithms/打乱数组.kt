import kotlin.random.Random


class Solution(val nums: IntArray) {

    private val shuffleNums = mutableListOf<Int>()

    init {
        nums.forEach { shuffleNums.add(it) }
    }

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        return nums
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        for (i in (shuffleNums.indices - 1)) {
            val lastTemp = shuffleNums[shuffleNums.size - i - 1]
            val index = Random.nextInt(0, shuffleNums.size - i)
            shuffleNums[shuffleNums.size - i -1] = shuffleNums[index]
            shuffleNums[index] = lastTemp
        }
        return shuffleNums.toIntArray()
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */