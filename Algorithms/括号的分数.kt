import java.util.*

class Solution {
    fun scoreOfParentheses(s: String): Int {
        val stack = LinkedList<Pair<Char, Int>>()
        var result = 0

        for (char in s) {
            if (char == '(') {
               stack.addLast(Pair(char, 0))
            } else {
                var last = stack.removeLast()
                val score = if (last.second == 0) 1 else 2 * last.second
                if (stack.isEmpty()) {
                    result += score 
                } else {
                    last = stack.removeLast() 
                    stack.addLast(Pair('(', last.second + score))
                }
            }
        }
        
        return result
    }
}

