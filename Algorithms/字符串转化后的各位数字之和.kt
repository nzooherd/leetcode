class Solution {
    fun getLucky(s: String, k: Int): Int {
        var numS = ""
        for (c in s.toCharArray()) {
            numS += (c - 'a' + 1).toString()
        }
        var nextNumS = 0
        var k = k
        while (k > 0) {
            nextNumS = 0
            for (c in numS.toCharArray()) {
                nextNumS += Integer.parseInt(c.toString())
            }
            numS = nextNumS.toString()
            k -= 1
        }
        return nextNumS
    }
}