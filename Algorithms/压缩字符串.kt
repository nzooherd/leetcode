class Solution {
    fun compress(chars: CharArray): Int {
        if (chars.isEmpty()) {
            return 0
        }

        var preChar : Char? = null
        var curNum = 0
        var index = 0

        for (char in chars) {
            if (preChar == null) {
                preChar = char
                curNum = 1
                continue
            }
            if (char != preChar) {
                chars[index++] = preChar
                if (curNum != 1) {
                    curNum.toString().forEach { chars[index++] = it }
                }
                preChar = char
                curNum = 1
            } else {
                curNum += 1
            }
        }
        chars[index++] = preChar!!
        if (curNum != 1) {
            curNum.toString().forEach { chars[index++] = it }
        }
        return index
    }
}