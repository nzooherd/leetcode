class StockPrice() {

    val timestampPriceMap = mutableMapOf<Int, Int>()
    var maxTimestamp = Int.MIN_VALUE
    var expirePriceMap = mutableMapOf<Int, MutableSet<Int>>()

    val maxPriorityQueue = PriorityQueue<Pair<Int, Int>>( kotlin.Comparator { o1, o2 ->
        o2.first.compareTo(o1.first)} )
    val minPriorityQueue = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
        o1.first.compareTo(o2.first)
    }

    fun update(timestamp: Int, price: Int) {
        if (timestamp > maxTimestamp) {
            maxTimestamp = timestamp
        }
        if (timestampPriceMap.containsKey(timestamp)) {
            val expirePrices = expirePriceMap.getOrDefault(timestamp, mutableSetOf())
            expirePrices.add(timestampPriceMap[timestamp]!!)
            expirePrices.remove(price)
            expirePriceMap[timestamp] = expirePrices
        }

        timestampPriceMap[timestamp] = price
        maxPriorityQueue.add(Pair(price, timestamp))
        minPriorityQueue.add(Pair(price, timestamp))

    }

    fun current(): Int {
        return timestampPriceMap[maxTimestamp]!!
    }

    fun maximum(): Int {
        while(maxPriorityQueue.isNotEmpty()) {
            val max = maxPriorityQueue.first()
            if (!expirePriceMap.containsKey(max.second)) {
                return max.first    
            }
            if (!expirePriceMap[max.second]!!.contains(max.first)) {
                return max.first
            }
            maxPriorityQueue.remove()
        }
        return -1
    }

    fun minimum(): Int {
        while(minPriorityQueue.isNotEmpty()) {
            val max = minPriorityQueue.first()
            if (!expirePriceMap.containsKey(max.second)) {
                return max.first
            }
            if (!expirePriceMap[max.second]!!.contains(max.first)) {
                return max.first
            }
            minPriorityQueue.remove()
        }
        return -1
    }

}

/**
 * Your StockPrice object will be instantiated and called as such:
 * var obj = StockPrice()
 * obj.update(timestamp,price)
 * var param_2 = obj.current()
 * var param_3 = obj.maximum()
 * var param_4 = obj.minimum()
 */