class Trie(val value: Char){
    private val children : MutableMap<Char, Trie> = mutableMapOf()
    private var word = ""

    fun insertWord(word: String) {
        var cur = this
        for (c in word) {
            cur= cur.children.computeIfAbsent(c) { Trie(c) }
        }
        cur.word = word
    }

    fun hasChildren(char: Char) : Trie? {
        return children[char]
    }

    fun isEnd() : Boolean {
        return word != ""
    }

    fun word(): String = word

}

class Solution {
    private val ans: MutableSet<String> = mutableSetOf()
    private var board: Array<CharArray>? = null

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        this.board = board
        val root = Trie('0')
        words.forEach { root.insertWord(it) }
        for (i in board.indices) {
            for (j in 0 until board[0].size) {
                dfs(root, i, j)
            }
        }
        return ans.toList()
    }

    private fun dfs(root: Trie, i: Int, j: Int) {
        val child = root.hasChildren(board!![i][j]) ?: return
        if (child.isEnd()) {
            ans.add(child.word())
        }

        val c = board!![i][j]
        board!![i][j] = '#'
        for (diff in listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))) {
                val newI = i + diff.first; val newJ = j + diff.second
                if (newI >= 0 && newI < board!!.size && newJ >= 0 && newJ < board!![0].size && board!![newI][newJ] != '#') {
                    dfs(child, newI, newJ)
                }
        }
        board!![i][j] = c

    }
}

