class WrapString(val value: String, var time: Int) {
}

class Trie {
    val children = mutableMapOf<Char, Trie>()
    val wrapStrings = mutableListOf<WrapString>()

    fun build(wrapS: WrapString) {
        var curRoot = this
        for (c in wrapS.value) {
            curRoot = curRoot.children.computeIfAbsent(c) { Trie() }
            curRoot.wrapStrings.add(wrapS)
        }
    }

    fun insert(wrapS: WrapString, isNew: Boolean) {
        var curRoot = this
        for (c in wrapS.value) {
            curRoot = curRoot.children.computeIfAbsent(c) { Trie() }
            var index =  0
            while (index < curRoot.wrapStrings.size) {
                if (curRoot.wrapStrings[index] == wrapS) {
                    break
                }
                index += 1
            }
            if (index == curRoot.wrapStrings.size) {
                curRoot.wrapStrings.add(wrapS)
            }

            curRoot.wrapStrings.sortWith(compareBy({ -it.time }, {it.value}))
        }
    }

}

class AutocompleteSystem(sentences: Array<String>, times: IntArray) {

    val stringWrapMap = mutableMapOf<String, WrapString>()

    val root: Trie = Trie().also { root ->
        sentences.forEachIndexed { index, sentence ->
            root.build(WrapString(sentence, times[index]).also { stringWrapMap[sentence] = it })
        }
        sortTrieByTime(root)
    }
    var curRoot: Trie? = root
    var curWord: String = ""

    fun input(c: Char): List<String> {
        if (c == '#') {
            curRoot = root
            if (stringWrapMap.containsKey(curWord)) {
                stringWrapMap[curWord]!!.time += 1
                root.insert(stringWrapMap[curWord]!!, false)
            } else {
                root.insert(WrapString(curWord, 1).also { stringWrapMap[curWord] = it }, true)
            }
            curWord = ""
            return listOf()
        }
        curWord += c
        if (curRoot == null) {
            return listOf()
        }
        curRoot = curRoot!!.children[c]
        if (curRoot == null) {
            return listOf()
        }
        val ans = mutableListOf<String>()
        for (i in 0 until 3) {
            if (curRoot!!.wrapStrings.size > i) {
                ans.add(curRoot!!.wrapStrings[i].value)
            }
        }
        return ans
    }

    private fun sortTrieByTime(root: Trie) {
        root.wrapStrings.sortWith(compareBy({ -it.time }, {it.value}))
        for (childrenTrie in root.children.values) {
            sortTrieByTime(childrenTrie)
        }
    }

}
