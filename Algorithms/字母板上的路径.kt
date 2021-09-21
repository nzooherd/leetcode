class Solution {
    fun alphabetBoardPath(target: String): String {
        val map = mutableMapOf<Char, Pair<Int, Int>>()
        for (i in 0..26) {
            val c = 'a' + i
            map[c] = Pair(i / 5, i % 5)
        }

        var result = ""
        var x = 0; var y = 0;
        for (c in target) {

            val curX = (c - 'a') / 5; val curY = (c - 'a') % 5;

            if (map[c]!!.second < y) {
                result += "L".repeat(y - map[c]!!.second)
            }
            if (map[c]!!.first < x) {
                result += "U".repeat(x - map[c]!!.first)
            }
            if (map[c]!!.first >= x) {
                result += "D".repeat(map[c]!!.first - x)
            }
            if (map[c]!!.second >= y) {
                result += "R".repeat(map[c]!!.second - y)
            }

            result += '!'
            x = curX; y = curY;
        }
        return result
    }
}