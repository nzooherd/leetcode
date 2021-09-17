class Solution {
    fun maxProduct(s: String): Int {
        val sLength = s.length
        val length = 1 shl sLength
        val dp =  BooleanArray(length) {false}
        for (i in 0 until sLength) {
            val num = 1 shl i
            dp[num] = true
        }

        var result = 0
        for (i in 1 until length) {
            if (i and (i - 1) == 0) {
                continue
            }
            if (numStrIsReverse(i, s)) {
                dp[i] = true
            }

            var j = i and (i - 1)
            while (j > 0) {
                if (dp[j] && dp[i - j]) {
                   result = result.coerceAtLeast(count1OfNum(j) * count1OfNum(i - j))
                }
                j = i and (j - 1)
            }
        }
        return result
    }

    fun count1OfNum(num: Int) : Int {
        var result = 0
        var varNum = num
        while (varNum > 0) {
            result += 1
            varNum = varNum and (varNum - 1)
        }
        return result
    }

    fun numStrIsReverse(num: Int, s: String) : Boolean {
        var index = 0
        var varNum = num
        var subS : String = ""
        while (varNum > 0) {
            if (varNum and 1 == 1) {
                subS += s[index]
            }
            index += 1
            varNum = varNum shr 1
        }
        return subS == subS.reversed()
    }
}