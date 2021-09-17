class Solution {
    fun numOfStrings(patterns: Array<String>, word: String): Int = patterns
        .map { if (word.contains(it)) 1 else 0 }.sum()
}