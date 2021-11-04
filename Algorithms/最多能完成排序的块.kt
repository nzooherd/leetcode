class Solution {
    fun maxChunksToSorted(arr: IntArray): Int {
        val minimumAfter = mutableListOf<Int>()
        var minimum = Int.MAX_VALUE
        for (i in arr.size-1 downTo  0 ) {
            minimum = minimum.coerceAtMost(arr[i])
            minimumAfter.add(minimum)
        }
        minimumAfter.reverse()

        if (arr.size <= 1) {
            return arr.size
        }

        var curMax = arr[0]

        var result = 1
        for (i in 1 until arr.size) {
            if (minimumAfter[i] > curMax) {
                result += 1
                curMax = arr[i]
            } else {
                curMax = curMax.coerceAtLeast(arr[i])
            }
        }
        return result
    }
}