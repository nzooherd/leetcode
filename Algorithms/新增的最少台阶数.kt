class Solution {
    fun addRungs(rungs: IntArray, dist: Int): Int {
        var result = 0
        for (i in rungs.indices) {
            val diff = if (i == 0) rungs[i] else rungs[i] - rungs[i-1]
            result += ((diff-1) / dist)
        }
        return result

    }
}