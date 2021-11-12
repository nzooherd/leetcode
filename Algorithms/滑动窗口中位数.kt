class Solution {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val sortNums = IntArray(k) {nums[it]}
        sortNums.sort()
        val result = mutableListOf<Double>()
        result.add(midNum(sortNums))

        for (i in k until nums.size) {
            val removeNum = nums[i - k]
            val index = sortNums.binarySearch(removeNum)
            sortNums[index] = nums[i]

            var realIndex = index
            while (realIndex != (k - 1)  && sortNums[realIndex] > sortNums[realIndex + 1]) {
                sortNums[realIndex] = sortNums[realIndex + 1]
                realIndex += 1
                sortNums[realIndex] = nums[i]
            }
            while (realIndex != 0 && sortNums[realIndex] < sortNums[realIndex - 1]) {
                sortNums[realIndex] = sortNums[realIndex - 1]
                realIndex -= 1
                sortNums[realIndex] = nums[i]
            }
            sortNums[realIndex] = nums[i]
            result.add(midNum(sortNums))
        }
        return result.toDoubleArray()
    }

    fun midNum(nums: IntArray) : Double {
        if (nums.size % 2 == 1) {
            return nums[nums.size / 2].toDouble()
        } else {
            return (nums[nums.size / 2 - 1].toDouble() + nums[nums.size / 2].toDouble()) / 2
        }
    }
}