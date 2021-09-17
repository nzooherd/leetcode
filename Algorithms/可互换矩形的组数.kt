class Solution {
    fun interchangeableRectangles(rectangles: Array<IntArray>): Long {
        val ratioNumMap = mutableMapOf<Double, Int>()
        var result = 0L
        for (rectangle in rectangles) {
            val ratio : Double = rectangle[1] * 1.0 / rectangle[0]
            val curResult = ratioNumMap.getOrDefault(ratio, 0)
            result += ratioNumMap.getOrDefault(ratio, 0)
            ratioNumMap[ratio] = curResult + 1
        }
        return result
    }
}