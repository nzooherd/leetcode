import java.util.*

class Solution {
    fun calculate(s: String): Int {
        val items = split(s.replace(" ", ""))

        val operators = listOf("+", "-", "*", "/", "(", ")")
        val operatorStack = Stack<Pair<Char, Int>>()
        val operandStack = Stack<Pair<Int, Int>>()

        for (index in items.indices) {
            val item = items[index]
            if (item !in operators) {
                operandStack.push(Pair(item.toInt(), index))
                continue
            }
            if (item == "(") {
                operatorStack.push(Pair(item[0], index))
            } else if (item == ")") {
                while (operatorStack.lastElement().first != '(') {
                    popCalculate(operatorStack, operandStack)
                }
                operatorStack.pop()
            } else {
                while (operatorStack.isNotEmpty() && operatorStack.lastElement().first != '(' &&
                    getPriority(item[0]) <= getPriority(operatorStack.lastElement().first)) {
                    popCalculate(operatorStack, operandStack)
                }
                operatorStack.push(Pair(item[0], index))
            }
        }
        while (operatorStack.isNotEmpty()) {
            popCalculate(operatorStack, operandStack)
        }
        return operandStack[0].first
    }

    private fun getPriority(operator: Char): Int {
        return when (operator) {
            '+', '-' -> 1
            '*', '/' -> 2
            else -> 0
        }
    }

    private fun popCalculate(operatorStack: Stack<Pair<Char, Int>>, operandStack: Stack<Pair<Int, Int>>) {
        val op = operatorStack.pop()
        val right = operandStack.pop()
        val left =
            if (operandStack.isNotEmpty() && ( operatorStack.isEmpty() || operatorStack.lastElement().first != '('  ||
                (operandStack.isNotEmpty() && operandStack.lastElement().second > operatorStack.lastElement().second))) {
                operandStack.pop()
            } else {
                Pair(0, 0)
            }
        operandStack.push(Pair(calculateDo(left.first, op.first, right.first), right.second))
    }

    private fun calculateDo(left: Int, op: Char, right: Int): Int {
        return when (op) {
            '+' -> left + right
            '-' -> left - right
            '*' -> left * right
            '/' -> left / right
            else -> throw IllegalArgumentException("unknown operator $op")
        }
    }


    fun split(s: String): List<String> {
        val delimiters = listOf('+', '-', '*', '/', '(', ')')
        val delimiterIndexes = mutableListOf<Int>()
        for (i in s.indices) {
            if (s[i] in delimiters) {
                delimiterIndexes.add(i)
            }
        }
        if (delimiterIndexes.size == 0) {
            return listOf(s)
        }
        val items = mutableListOf<String>()
        if (delimiterIndexes[0] != 0) {
            items.add(s.substring(0, delimiterIndexes[0]))
        }
        for (i in 0 until delimiterIndexes.size) {
            items.add(s[delimiterIndexes[i]].toString())
            if (i < delimiterIndexes.size - 1) {
                items.add(s.substring(delimiterIndexes[i] + 1, delimiterIndexes[i + 1]))
            }
        }
        if (delimiterIndexes[delimiterIndexes.size - 1] != s.length - 1) {
            items.add(s.substring(delimiterIndexes[delimiterIndexes.size - 1] + 1))
        }
        return items.filter { it.isNotEmpty() }
    }

}

