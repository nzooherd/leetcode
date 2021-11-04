import java.util.*

class Solution {
    fun calculate(s: String): Int {
        val items = split(s)

        val operators = listOf("+", "-", "*", "/", "(", ")")
        val operatorStack = Stack<Char>()
        val operandStack = Stack<Int>()

        for (item in items) {
            if (item !in operators) {
                operandStack.push(item.toInt())
                continue
            }
            if (item == "(") {
                operatorStack.push(item[0])
            } else if (item == ")") {
                while (operatorStack.lastElement() != '(') {
                    val op = operatorStack.pop()
                    val right = operandStack.pop()
                    val left = operandStack.pop()
                    operandStack.push(calculateDo(left, op, right))
                }
                operatorStack.pop()
            } else {
                while (operatorStack.isNotEmpty() && operatorStack.lastElement() != '(' &&
                    getPriority(item[0]) <= getPriority(operatorStack.lastElement())) {
                    val op = operatorStack.pop()
                    val right = operandStack.pop()
                    val left = operandStack.pop()
                    operandStack.push(calculateDo(left, op, right))
                }
                operatorStack.push(item[0])
            }
        }
        while (operatorStack.isNotEmpty()) {
            val op = operatorStack.pop()
            val right = operandStack.pop()
            val left = operandStack.pop()
            operandStack.push(calculateDo(left, op, right))
        }
        return operandStack[0]
    }

    private fun getPriority(operator: Char): Int {
        return when (operator) {
            '+', '-' -> 1
            '*', '/' -> 2
            else -> 0
        }
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

