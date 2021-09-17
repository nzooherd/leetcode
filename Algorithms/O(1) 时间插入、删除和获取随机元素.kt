import kotlin.random.Random

class RandomizedSet() {

    /** Initialize your data structure here. */

    private val nums = mutableListOf<Int>()
    private var size = 0
    private val numIndexMap = mutableMapOf<Int, Int>()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (numIndexMap.contains(`val`)) {
            return false
        }
        if (nums.size > size) {
            nums[size] = `val`
        } else {
            nums.add(`val`)
        }
        numIndexMap[`val`] = size
        size += 1
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        if (!numIndexMap.contains(`val`)) {
            return false
        }
        val index = numIndexMap[`val`]!!
        if (index == size - 1) {
            numIndexMap.remove(`val`)
        } else {
            numIndexMap.remove(`val`)
            nums[index] = nums[size-1]
            numIndexMap[nums[index]] = index
        }
        size -= 1
        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        return nums[Random.nextInt(0, size)]
    }

}