import kotlin.random.Random

class RandomizedCollection() {

    private val data = mutableListOf<Int>()
    private var lastIndex = 0
    private val valueIndexesMap = mutableMapOf<Int, MutableSet<Int>>()

    fun insert(`val`: Int): Boolean {
        if (data.size <= lastIndex) {
            data.add(`val`)
        } else {
            data[lastIndex] = `val`
        }
        val indexes = valueIndexesMap.getOrDefault(`val`, mutableSetOf())
        indexes.add(lastIndex)
        lastIndex += 1
        valueIndexesMap[`val`] = indexes
        return indexes.size == 1
    }

    fun remove(`val`: Int): Boolean {
        if (valueIndexesMap.getOrDefault(`val`, mutableSetOf()).size <= 0) {
            return false
        }
        val indexes = valueIndexesMap[`val`]!!
        lastIndex -= 1
        val replaceIndex = indexes.first()
        indexes.remove(replaceIndex)
        if (lastIndex != replaceIndex) {
            val replaceNum = data[lastIndex]
            valueIndexesMap[replaceNum]!!.remove(lastIndex)
            data[replaceIndex] = replaceNum
            valueIndexesMap[replaceNum]!!.add(replaceIndex)
        }
        return true
    }

    fun getRandom(): Int {
        return data[Random.nextInt(0, lastIndex)]
    }

}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * var obj = RandomizedCollection()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */
