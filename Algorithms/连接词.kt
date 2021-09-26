class Trie() {
    private val children = mutableMapOf<Char, Trie>()
    private val containsWord = mutableMapOf<String, Boolean>()
    private var word = ""

    fun insert(word: String) {
        var curRoot = this
        for (c in word) {
            curRoot = curRoot.children.computeIfAbsent(c) {Trie()}
        }
        curRoot.word = word
    }

    fun hasChild(c: Char) = children[c] != null

    fun word(): String = word


    fun isConcatWord(root: Trie, word: String) : Boolean{
        var curRoot = this
        for (index in 0 until word.length - 1) {
            val ch = word[index]
            if (curRoot.hasChild(ch)) {
                curRoot = curRoot.children[ch]!!
                if (curRoot.word != "" && contains(word.substring(index+1))) {
                    return true
                }
            } else {
                return false
            }
        }
        return false
    }

    fun contains(word: String) : Boolean{
        if (containsWord.containsKey(word)) {
            return containsWord[word]!!
        }


        var result = false
        var curRoot = this
        for (index in word.indices) {
            val ch = word[index]
            if (curRoot.hasChild(ch)) {
                curRoot = curRoot.children[ch]!!
                if (index == word.length - 1) {
                    result = curRoot.word != ""
                    break
                } else {
                    if (curRoot.word != "" && contains(word.substring(index+1))) {
                        result = true
                        break
                    }
                }

            } else {
                result = false
                break
            }
        }

        containsWord[word] = result
        return result
    }

}

class Solution {
    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
        val root = Trie()
        words.forEach{  root.insert(it) }
        val ans = mutableListOf<String>()
        for (word in words) {
            if (root.isConcatWord(root, word)) {
                ans.add(word)
            }
        }
        return ans
    }
}