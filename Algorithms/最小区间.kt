
/**
 * @author shiwenhao <shiwenhao@kuaishou.com>
 * Created on 2021/9/3
 */

class Solution {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        val allNum = mutableListOf<Pair<Int, Int>>()
        val indexes = IntArray(nums.size) {0}
        val sumCount = nums.map { it.count() }.sum()

        while (allNum.size < sumCount) {
            var min = Int.MAX_VALUE; var minIndex = 0;
            for (i in indexes.indices) {
                if (indexes[i] >= nums[i].size) {
                    continue
                }
                if (nums[i][indexes[i]] < min) {
                    minIndex = i
                    min = nums[i][indexes[i]]
                }
            }
            allNum.add(Pair(nums[minIndex][indexes[minIndex]], minIndex))
            indexes[minIndex] += 1
        }

        var left = 0; var right = 0
        var ans = Pair(0, Int.MAX_VALUE)

        val indexCountMap = mutableMapOf<Int, Int>()
        var indexCount = 0

        while (right < allNum.size) {
            val rightNum = allNum[right].first; val rightIndex = allNum[right].second
            if (indexCountMap.getOrDefault(rightIndex, 0) != 0) {
                indexCountMap[rightIndex] = indexCountMap[rightIndex]!! + 1
            } else {
                indexCount += 1
                indexCountMap[rightIndex] = 1
            }
            while (indexCount == nums.size) {
                val leftNum = allNum[left].first; val leftIndex = allNum[left].second
                if (rightNum - leftNum < ans.second - ans.first) {
                    ans = Pair(leftNum, rightNum)
                }
                indexCountMap[leftIndex] = indexCountMap[leftIndex]!! - 1
                if (indexCountMap[leftIndex]!! == 0) {
                    indexCount -= 1
                }
                left += 1
            }
            right += 1
        }
        return intArrayOf(ans.first, ans.second)
    }
}

