import java.util.*

class Solution {
    fun expand(expression: String): List<String> {
        val items =  split(expression)
        val operands = Stack<Set<String>>()
        val operators = setOf("{", "}", ",")
        for (item in items) {
            if (item !in operators) {
                operands.push(setOf(item))
                continue
            }
            if (item == "{" || item == ",") {
                operands.push(setOf(item))
            } else {
                val curResult = mutableSetOf<String>()
                while (operands.lastElement() != setOf("{")) {
                    val multiplyStack = Stack<Set<String>>()
                    while (operands.lastElement() != setOf("{") && operands.lastElement() != setOf(",")) {
                        multiplyStack.add(operands.pop())
                    }
                    var tempResult = multiplyStack.pop()
                    while (multiplyStack.isNotEmpty()) {
                        tempResult = multiplyStack.pop().flatMap { next ->
                            tempResult.map { last -> last + next }
                        }.toSet()
                    }
                    if (operands.lastElement() == setOf(",")) {
                        operands.pop()
                    }
                    curResult.addAll(tempResult)
                }
                operands.pop()
                operands.push(curResult)
            }
        }
        val curResult = mutableSetOf<String>()
        while (operands.isNotEmpty()) {
            val multiplyStack = Stack<Set<String>>()
            while (operands.isNotEmpty() && operands.lastElement() != setOf(",")) {
                multiplyStack.add(operands.pop())
            }
            var tempResult = multiplyStack.pop()
            while (multiplyStack.isNotEmpty()) {
                tempResult = multiplyStack.pop().flatMap { next ->
                    tempResult.map { last -> last + next }
                }.toSet()
            }
            if (operands.isNotEmpty() && operands.lastElement() == setOf(",")) {
                operands.pop()
            }
            curResult.addAll(tempResult)
        }
        operands.push(curResult)
        return operands.lastElement().toList().sorted()
    }

    fun split(expression: String): List<String> {
        val express = expression.replace(" ", "")
        val delimiters = setOf('{', '}', ',')
        val delimiterIndexes = mutableListOf<Int>()
        for (i in express.indices) {
            if (express[i] in delimiters) {
                delimiterIndexes.add(i)
            }
        }
        if (delimiterIndexes.size == 0) {
            return listOf(express)
        }

        val items = mutableListOf<String>()
        if (delimiterIndexes[0] != 0) {
            items.add(expression.substring(0, delimiterIndexes[0]))
        }
        for (i in 0 until delimiterIndexes.size - 1) {
            items.add(express.substring(delimiterIndexes[i], delimiterIndexes[i] + 1))
            items.add(express.substring(delimiterIndexes[i] + 1, delimiterIndexes[i + 1]))
        }
        items.add(express.substring(delimiterIndexes.last(), delimiterIndexes.last() + 1))
        if (delimiterIndexes.last() != express.length - 1) {
            items.add(express.substring(delimiterIndexes.last() + 1, express.length))
        }
        return items.filter { it.isNotBlank() }
    }

}
