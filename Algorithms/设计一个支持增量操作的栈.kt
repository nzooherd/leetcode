class CustomStack(private val maxSize: Int) {
    private val stack = mutableListOf<Int>()
    private val accumulateAdd = mutableListOf<Int>()
    private var index = 0

    fun push(x: Int) {
        if (index < maxSize) {
            stack.add(index, x)
            accumulateAdd.add(index, 0)
            index += 1
        }
    }

    fun pop(): Int {
        if (index <= 0) {
            return -1
        }
        index--
        val result = stack[index] + accumulateAdd[index]
        if (index >= 1) {
            accumulateAdd[index - 1] += if (accumulateAdd.size > index) accumulateAdd[index] else 0
        }
        accumulateAdd[index] = 0
        return result
    }

    fun increment(k: Int, `val`: Int) {
        val realK = k.coerceAtMost(index)
        if (realK == 0) {
            return
        }
        accumulateAdd[realK - 1] += `val`
    }
}