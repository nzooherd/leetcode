import java.util.*

class Solution {
    fun parseBoolExpr(expression: String): Boolean {
        val operatorStack = LinkedList<Char>()
        val operators = setOf<Char>('!', '&', '|')
        val resultStack = LinkedList<Char>()

        for (c in expression) {
            if (c == ',') {
                continue
            }
            if (operators.contains(c)) {
                operatorStack.addLast(c)
                continue
            }
            if (c == '(') {
                resultStack.addLast(c)
                continue
            }
            if (c == ')') {
                val operator = operatorStack.pollLast()
                val args = mutableListOf<Char>()
                while (resultStack.last() != '(') {
                    args.add(resultStack.pollLast())
                }
                resultStack.pollLast()
                resultStack.addLast(if (simpleExpr(operator, args)) 't' else 'f')
                continue
            }
            resultStack.addLast(c)
        }
        return resultStack.pollLast() == 't'
    }

    private fun simpleExpr(operator: Char, args: List<Char>) : Boolean {
        if (operator == '!') {
            if (args.size > 1) {
                throw IllegalStateException("!参数过多")
            }
            return args[0] != 't'
        }
        if (operator == '&') {
            return !args.contains('f')
        }
        if (operator == '|') {
            return args.contains('t')
        }
        return false
    }

}
