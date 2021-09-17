import java.util.*

class Solution {
    fun minStoneSum(piles: IntArray, k: Int): Int {
        val nums: PriorityQueue<Int> = PriorityQueue<Int>(compareBy { -it })
        piles.forEach { nums.add(it) }
        val sums = piles.sum()
        var newK = k
        while ( newK > 0) {
            val top = nums.poll()
            nums.add(top - top / 2)
            newK -= 1
        }
        return nums.sum()
    }
}