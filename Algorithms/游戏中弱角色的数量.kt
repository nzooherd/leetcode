class Solution {
    fun numberOfWeakCharacters(properties: Array<IntArray>): Int {
        properties.sortWith(Comparator<IntArray> { property1 : IntArray, property2 : IntArray->
            var comp = 0
            comp = if (property1[0] > property2[0]) {
                -1
            } else if (property1[0] < property2[0]) {
                1
            } else {
                property1[1].compareTo(property2[1])
            }
            comp
        })
        var curMax = 0
        var result = 0
        for (property in properties) {
            if (property[1] < curMax) {
                result += 1
            }
            curMax = curMax.coerceAtLeast(property[1])
        }
        return result
    }
}