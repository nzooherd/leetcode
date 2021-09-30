class Solution {
    fun maxPoints(points: Array<IntArray>): Int {
        var ans = 0
        for (firstPoint in points) {
            val curAns = mutableMapOf<Pair<Int, Int>, Int>()
            for (secondPoint in points) {
                if (secondPoint == firstPoint) {
                    continue
                }
                val diffX = secondPoint[0] - firstPoint[0]
                val diffY = secondPoint[1] - firstPoint[1]
                val gcdNum = gcd(kotlin.math.abs(diffX), kotlin.math.abs(diffY))
                val pair = Pair(diffX / gcdNum, diffY / gcdNum)
                curAns[pair] = curAns.getOrDefault(pair, 0) + 1
                ans = ans.coerceAtLeast(curAns[pair]!!)
            }
        }
        return ans + 1
    }

    fun gcd(x: Int, y: Int): Int {
        val mutX = x.coerceAtLeast(y)
        val mutY = x.coerceAtMost(y)
        if (mutX == 0) {
            return 1
        }
        if (mutY == 0) {
            return mutX
        }
        return gcd(y, x % y)
    }
}