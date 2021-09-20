class Solution {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        return operations.count { it.contains("+") } -  operations.count { it.contains("-") }
    }
}