class Solution {
    fun minSessions(tasks: IntArray, sessionTime: Int): Int {
        val len = 1 shl tasks.size
        val dp = Array(len) {20}
        for (i in 1 until len) {
            var sumTime = 0
            var index = 0
            var num = i
            while (num > 0) {
                if (num and  1 == 1) {
                    sumTime += tasks[index]
                }
                index += 1
                num = num shr 1
            }
            if (sumTime <= sessionTime) {
                dp[i] = 1
            }
        }
        for (i in 1 until len) {
            if (dp[i] == 1) {
                continue
            }
            var j = i
            while (j > 0) {
                j = (j - 1) and i
                dp[i] = dp[i].coerceAtMost(dp[j] + dp[j xor i])
            }
        }
        return dp[len-1]
    }
}