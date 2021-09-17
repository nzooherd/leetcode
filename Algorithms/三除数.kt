class Solution {
    fun isThree(n: Int): Boolean {
        var i = 1
        var count = 0
        while (i * i < n) {
            if (n % i == 0) {
                count += 1
            }
            if (count == 2) {
                return false
            }
            i += 1
        }
        if (i * i == n && count == 1) {
            return true
        }
        return false

    }
}
