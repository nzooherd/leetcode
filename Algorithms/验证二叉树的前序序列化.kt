import java.util.*

class Solution {
    fun isValidSerialization(preorder: String): Boolean {
        if (preorder == "#") {
            return true
        }
        val stack = LinkedList<Pair<String, Boolean>>()
        var pre = true
        val items = preorder.split(",")
        for (index in items.indices) {
            val char = items[index]
            if (char != "#") {
                stack.add(Pair(char, pre))
                pre = true
                continue
            }

            if (stack.isEmpty()) {
                return false
            }
            if (pre) {  //左子树
                pre = false
            } else {
                var last = stack.pollLast()
                if (stack.isEmpty()) {
                    return index == items.size - 1
                }
                while (!last.second) {
                    last = stack.pollLast()
                    if (stack.isEmpty()) {
                        return index == items.size - 1
                    }
                }
            }
        }
        stack.forEach { println(it)}
        return stack.isEmpty()
    }
}