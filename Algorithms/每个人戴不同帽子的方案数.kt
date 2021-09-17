class Solution {
    fun numberWays(hats: List<List<Int>>): Int {
        val len = 1 shl hats.size
        val dp = Array(41) { Array(len) { 0L } }
        for (i in 1..40) {
            for (j in 1 until len) {
                var result = dp[i-1][j]
                var index = -1; var num = j
                while (num > 0) {
                    index += 1
                    if (num and 1 == 1 && hats[index].contains(i)) {
                        val tmp = j xor (1 shl index)
                        result += if (tmp != 0) dp[i-1][j xor (1 shl index)] else 1
                        num = num shr 1
                    } else {
                        num = num shr 1
                        continue
                    }
                }
                dp[i][j] = result % (1000000007)
            }
        }
        return dp[40][len - 1].toInt()
    }
}
