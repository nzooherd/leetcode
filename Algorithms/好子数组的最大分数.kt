import java.util.*

class Solution {
    fun maximumScore(nums: IntArray, k: Int): Int {
        val stack = Stack<Pair<Int, Int>>()
        val rightMinimum = mutableMapOf<Int, Int>()
        val leftMinimum = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val value = nums[i]
            while(stack.isNotEmpty() && stack.lastElement().first > value) {
                val lastItem = stack.pop()
                rightMinimum[lastItem.second] = i - 1
            }
            stack.push(Pair(value, i))
        }
        while (stack.isNotEmpty()) {
            rightMinimum[stack.pop().second] = nums.size - 1
        }

        for (i in nums.size - 1 downTo 0) {
            val value = nums[i]
            while(stack.isNotEmpty() && stack.lastElement().first > value) {
                val lastItem = stack.pop()
                leftMinimum[lastItem.second] = i + 1
            }
            stack.push(Pair(value, i))
        }
        while (stack.isNotEmpty()) {
            leftMinimum[stack.pop().second] = 0
        }

        var result = 0
        for (i in nums.indices) {
            val left: Int = leftMinimum[i]!!
            val right: Int = rightMinimum[i]!!
            if (k in left..right) {
                result = result.coerceAtLeast((right - left + 1) * nums[i])
            }
        }

        return result
    }
}
