class Solution {
    fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
        val nums1Set = nums1.toSet()
        val nums2Set = nums2.toSet()
        val nums3Set = nums3.toSet()
        val numCountMap = mutableMapOf<Int, Int>()
        val result = mutableListOf<Int>()
        for (num in nums1Set) {
            numCountMap[num] = numCountMap.getOrDefault(num, 0) +1 
        }
        for (num in nums2Set) {
            numCountMap[num] = numCountMap.getOrDefault(num, 0) +1
        }
        for (num in nums3Set) {
            numCountMap[num] = numCountMap.getOrDefault(num, 0) +1
        }     
        return numCountMap.filter { entry -> entry.value > 1 }.keys.toList()
        
        
    }
}