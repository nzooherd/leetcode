class Solution {
    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        val brokenChars = brokenLetters.toCharArray().toSet()
        var result = 0
        for (s in text.split(" ")) {
            result += if (s.toCharArray().map { !(it in brokenChars) }.all { it }) 1 else 0
        }
        return  result

    }
}
