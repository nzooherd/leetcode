class Solution {
    fun kEmptySlots(bulbs: IntArray, k: Int): Int {
        val size = bulbs.max()!! + 1

        val preBit = BIT(size + 1)
        val postBit = BIT(size + 1)
        for (i in bulbs.indices) {
            val index = bulbs[i]
            val pre = preBit.maxOf(index - 1)
            if (pre != 0 && (index - pre - 1) == k) {
                return i + 1
            }
            preBit.update(index, 1)

            val reverseIndex = size - index
            val post = postBit.maxOf(reverseIndex - 1)
            if (post != 0 && (reverseIndex - post - 1) == k) {
                return i + 1
            }
            postBit.update(reverseIndex, 1)
        }
        return -1
    }
}

class BIT(val size: Int) {
    private val values = IntArray(size) {0}

    private fun lowBit(index: Int) : Int = index and (-index)

    fun maxOf(index: Int) : Int {
        var result = 0
        var varIndex = index
        while (varIndex > 0) {
            result = result.coerceAtLeast(values[varIndex])
            varIndex -= lowBit(varIndex)
        }
        return result
    }

    fun update(index: Int, value: Int) {
        var varIndex = index
        while (varIndex < size) {
            if (values[varIndex] < index) {
                values[varIndex] = index
            }
            varIndex += lowBit(varIndex)
        }
    }
}

