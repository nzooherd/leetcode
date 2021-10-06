import java.util.*

class Solution {
    fun shortestSubarray(nums: IntArray, k: Int): Int {
        val suffixSum = Array(nums.size + 1) {0}
        suffixSum[0] = 0
        for (index in 1 until suffixSum.size) {
            suffixSum[index] = nums[index - 1] + suffixSum[index - 1]
        }

        var ans = nums.size + 1
        val monotonicQueue = LinkedList<Int>()
        monotonicQueue.addLast(-1)
        for (index in nums.indices) {
            val value = suffixSum[index + 1]
            while (monotonicQueue.isNotEmpty() && suffixSum[monotonicQueue.last() + 1] >= value) {
                monotonicQueue.pollLast()
            }
            while (monotonicQueue.isNotEmpty() && (value - suffixSum[monotonicQueue.first + 1]) >= k) {
                ans = ans.coerceAtMost(index - monotonicQueue.pop())
            }
            monotonicQueue.addLast(index)
        }
        return  if (ans != nums.size + 1) ans else -1


    }
}
