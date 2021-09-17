import kotlin.math.abs

class Solution {
    fun maxPoints(points: Array<IntArray>): Long {
        val matrix = mutableListOf<MutableList<Long>>()
        for (i in points.indices) {
            val row = mutableListOf<Long>()
            for (j in points[0].indices) {
                row.add((if (i == 0) points[i][j] else 0).toLong())
            }
            matrix.add(row)
        }
        for (i in 1 until points.size) {
            for (j in points[0].indices) {
                var maxValue = 0L
                for (k in points[0].indices) {
                    maxValue = maxValue.coerceAtLeast((matrix[i-1][k] + points[i][j] - abs(j - k)))
                }
                matrix[i][j] = maxValue
            }
        }

        return matrix[points.size - 1].max() ?: 0L
    }

}