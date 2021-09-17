class Solution {
    fun isPrefixString(s: String, words: Array<String>): Boolean {
        var newS = s
        for (word in words) {
            if (!newS.startsWith(word)) {
               return false
            }
            newS = newS.substring(word.length)
            if (newS.isEmpty()) {
                return true
            }
        }
        return false
    }
}