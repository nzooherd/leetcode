class CombinationIterator(private var characters: String, private val combinationLength: Int) {
    private var last: String? = null
    private val char2index = characters.toCharArray().withIndex().associate { Pair(it.value, it.index) }

    fun next(): String {
        if (last == null) {
            last = characters.substring(0, combinationLength)
            return last!!
        }

        for (i in combinationLength - 1 downTo 0) {
            val index = char2index[last!![i]]!!
            if (index == characters.length - 1) {
                continue
            }
            if (i == combinationLength - 1 || (char2index[last!![i + 1]]) != (index + 1)) {
                val endIndex = (combinationLength - i + index + 1)
                last = last!!.substring(0, i) + characters.substring(index + 1, endIndex)
                return last!!
            }
        }
        return ""
    }

    fun hasNext(): Boolean = last != characters.substring(characters.length - combinationLength)

}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * var obj = CombinationIterator(characters, combinationLength)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */