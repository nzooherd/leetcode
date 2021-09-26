class Node(val name: String, val dir: Boolean) {
    private val children = mutableMapOf<String, Node>()
    private var content = ""

    fun isDir() : Boolean = dir
    fun child(name: String) : Node {
        return children[name]!!
    }
    fun allChildren() : MutableMap<String, Node> {
        return children
    }

    fun writeContent(newContent: String) {
        content += newContent
    }
    fun readContent(): String {
        return content
    }

}


class FileSystem() {

    private val root = Node("/", true)

    fun ls(path: String): List<String> {
        val items = splitPath(path)
        var curRoot = root
        for (item in items) {
            curRoot = curRoot.child(item)
        }
        return if (curRoot.isDir()) {
            curRoot.allChildren().keys.sorted()
        } else {
            listOf(curRoot.name)
        }
    }

    fun mkdir(path: String) {
        val items = splitPath(path)
        var curRoot = root
        for (item in items) {
            curRoot = curRoot.allChildren().computeIfAbsent(item) {Node(item, true)}
        }
    }

    fun addContentToFile(filePath: String, content: String) {
        val items = splitPath(filePath)
        var curRoot = root
        for (index in items.indices) {
            val item = items[index]
            if (index != items.size - 1) {
                curRoot= curRoot.allChildren().computeIfAbsent(item) {Node(item, true)}
            } else {
                curRoot= curRoot.allChildren().computeIfAbsent(item) {Node(item, false)}
            }
        }
        curRoot.writeContent(content)
    }

    fun readContentFromFile(filePath: String): String {
        val items = splitPath(filePath)
        var curRoot = root
        for (item in items) {
            curRoot = curRoot.allChildren().computeIfAbsent(item) {Node(item, true)}
        }
        return curRoot.readContent()
    }

    private fun splitPath(path: String) : List<String> {
        val ans = mutableListOf<String>()
        var left = 0;
        for (right in 1 until path.length) {
            if (path[right] == '/') {
                ans.add(path.substring(left+1, right))
                left = right
            }
        }
        if (left != path.length - 1) {
            ans.add(path.substring(left+1))
        }
        return ans

    }

}
