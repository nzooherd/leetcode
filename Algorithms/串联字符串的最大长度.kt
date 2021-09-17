class Solution {
    fun maxLength(arr: List<String>): Int {
        val length = 1 shl arr.size
        val bits : Array<Int> = Array(length) {0}
        var maxResult = 0
        for (i in 0 until arr.size) {
            val num = 1 shl i
            var value = 0
            for (c in arr[i]) {
                val orValue = (1 shl (c.toInt() - 'a'.toInt()))
                if (value and orValue != 0) {
                    value = -1
                    break
                } else {
                    value = value or orValue
                }
            }
            bits[num] = value
            maxResult = maxResult.coerceAtLeast(oneNums(value))
        }
        for (i in 1 until length) {
            val j2 = (i - 1) and i
            val j1 = i xor j2
            if (j2 == 0 || j1 == 0) {
                continue
            }
            if (bits[j1] == -1 || bits[j2] == -1) {
                bits[i] = -1
                continue
            }
            if (bits[j1] and bits[j2] == 0) {
                bits[i] = bits[j1] or bits[j2]
                maxResult = maxResult.coerceAtLeast(oneNums(bits[i]))
            } else {
                bits[i] = -1
            }
        }
        return maxResult
    }

    fun oneNums(num: Int) : Int {
        if (num == -1) {
            return  0
        }
        var varNum = num
        var result = 0
        while (varNum > 0) {
            result += 1
            varNum = varNum and (varNum - 1)
        }
        return result
    }

}