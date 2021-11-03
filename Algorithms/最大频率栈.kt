import java.util.*

class FreqStack() {

    private val numFreqMap = mutableMapOf<Int, Int>()
    private val freqStack : MutableList<LinkedList<Int>>  = mutableListOf(LinkedList())
    private var maxFreq = 0

    fun push(`val`: Int) {
        var curFre = numFreqMap.computeIfAbsent(`val`) { 0 }
        curFre += 1
        numFreqMap[`val`] = curFre

        maxFreq = maxFreq.coerceAtLeast(curFre)

        if (freqStack.size <= curFre)  {
            freqStack.add(LinkedList())
        }

        freqStack[curFre].addLast(`val`)
    }

    fun pop(): Int {
        while (maxFreq > 0) {
            val curStack = freqStack[maxFreq]
            if (curStack.size != 0) {
                val result = curStack.pollLast()
                numFreqMap[result] = numFreqMap[result]!! - 1
                return result
            } else {
                maxFreq -= 1
            }
        }
        return -1
    }

}

/**
 * Your FreqStack object will be instantiated and called as such:
 * var obj = FreqStack()
 * obj.push(`val`)
 * var param_2 = obj.pop()
 */