class PeekingIterator(val iterator:Iterator<Int>):Iterator<Int> {
    private var value: Int? = null

    fun peek(): Int {
        if (value != null) {
            return value!!
        }
        value = iterator.next()
        return value!!
    }

    override fun next(): Int {
        if (value != null) {
            val tmpValue = value!!
            value = null
            return tmpValue
        }
        return iterator.next()
    }

    override fun hasNext(): Boolean {
        if (value != null) {
            return true
        }
        return iterator.hasNext()
    }
}

/**
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = PeekingIterator(arr)
 * var param_1 = obj.next()
 * var param_2 = obj.peek()
 * var param_3 = obj.hasNext()
 */