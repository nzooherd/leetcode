class Solution {
    fun countValidWords(sentence: String): Int {
        return sentence.split(" ").filter { it.isNotBlank() && isValidToken(it) }.size
    }

    fun isValidToken(token: String): Boolean {
        var hyphenCount = 0
        for (i in token.indices) {
            if (token[i] in '0'..'9') {
                return false
            }
            if (token[i] == '-') {
                if (i == 0 || i == token.length -1 ) {
                    return false
                }
                if (token[i-1] !in 'a'..'z' || token[i+1] !in 'a'..'z') {
                    return false
                }
                    
                hyphenCount += 1
            }
            if (token[i] == '!' || token[i] == '.' || token[i] == ',') {
               if (i != token.length - 1) {
                   return false
               }
            }
        }
        return hyphenCount <= 1
    }
}