class Solution {
    fun nextBeautifulNumber(n: Int): Int {
        var num = n + 1
        while (true) {
            if (isBalanceNum(num)) {
                return num
            }
            num += 1
        }
    }

    
    fun isBalanceNum(num: Int): Boolean {
        val numStr = num.toString()
        val numStrMap = numStr.groupBy { it }
        for ( (key, value) in numStrMap) {
            if (value.size != Integer.parseInt(key.toString())) {
                return false
            }
        }
        return true
        
    }
}