class Solution {
    fun letterCasePermutation(S: String): List<String> {
        val res = mutableListOf<String>()
        for((index, char) in S.withIndex()){
            if(char !in '0'..'9'){
                val prefixStr = S.substring(0..index-1)
                val nextRes = letterCasePermutation(S.slice(index+1..S.length-1))
                for(nextItem in nextRes){
                    res.add(prefixStr + char + nextItem)
                    res.add(prefixStr + (char +
                            (if (char > 'Z') ('A' - 'a') else ('a' - 'A')) +
                            nextItem))
                }
                return res
            }
        }
        res.add(S)
        return res
    }
}