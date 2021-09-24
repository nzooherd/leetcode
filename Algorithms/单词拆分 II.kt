class Trie {
    private val children: MutableMap<Char, Trie> = mutableMapOf()
    private var word: String? = null

    fun insertWord(word: String) {
        var root = this
        for (c in word) {
            root = root.children.computeIfAbsent(c) {Trie()}
        }
        root.word = word
    }

    fun isWord(): Boolean = word != null

    fun word(): String? = word

    fun child(c: Char): Trie? = children[c]
}

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val root = Trie()
        wordDict.forEach { root.insertWord(it) }
        val ans = dfs(s, root)
        return ans.map { it.reverse(); it.joinToString(" ") }

    }

    fun dfs(s: String, root: Trie):  MutableList<MutableList<String>> {
        val ans = mutableListOf<MutableList<String>>()
        var curRoot: Trie? = root
        for (index in s.indices) {
            val c = s[index]
            curRoot = curRoot!!.child(c)
            if (curRoot == null) {
                break
            }
            if (curRoot.isWord()) {
               if (index != s.length - 1) {
                   val nextAns = dfs(s.substring(index + 1), root)
                   nextAns.forEach {
                       it.add(it.size, s.substring(0, index + 1))
                       ans.add(it)
                   }
               } else {
                   ans.add(mutableListOf(s.substring(0, index + 1)))
               }
            }
        }
        return ans
    }
}
