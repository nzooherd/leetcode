class Solution {
    fun findMinDifference(timePoints: List<String>): Int {
        val intTimes = timePoints.map { sTimeToInt(it) }.sorted()
        var min = Int.MAX_VALUE
        for (i in 1 until intTimes.size) {
            min = min.coerceAtMost(intTimes[i] - intTimes[i - 1])
        }
        return min.coerceAtMost(24 * 60 - (intTimes[intTimes.size - 1] - intTimes[0]))
    }

    private fun sTimeToInt(sTime: String): Int {
        val items = sTime.split(":")
        return Integer.parseInt(items[0]) * 60 + Integer.parseInt(items[1])
    }
}