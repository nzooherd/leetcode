class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        if (s.length < 3) {
            return 0
        }
        val leftCharNumMap: MutableMap<Char, Int> = mutableMapOf<Char, Int>()
        val rightCharNumMap: MutableMap<Char, Int> = s.toCharArray().groupBy { it }
            .mapValues { entry -> entry.value.size }.toMutableMap()
            .withDefault { 0 }
        val result = setOf<String>().toMutableSet()
        for (i in s.indices) {
            if (i > 0) {
                leftCharNumMap[s[i-1]] = leftCharNumMap.getOrDefault(s[i-1], 0) + 1
                rightCharNumMap[s[i]] = rightCharNumMap[s[i]]!! - 1
            }
            if (i == 0 || i == s.length - 1) {
                rightCharNumMap[s[i]] = rightCharNumMap[s[i]]!! - 1
                continue
            }
            leftCharNumMap.keys.filter { key -> leftCharNumMap[key]!! > 0 }
                .filter { key -> rightCharNumMap[key]!! > 0 }
                .forEach {
                    result.add(it + s[i].toString() + it)
                }

        }
        return result.size
    }
}
