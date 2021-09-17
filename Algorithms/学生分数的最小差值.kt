class Solution {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        if (k > nums.size) {
            return -1
        }
        if (k == nums.size) {
            return nums.max()!! - nums.min()!!
        }
        if (k == 1) {
            return 0
        }
        nums.sort()
        var result = Int.MAX_VALUE
        for (i in 0..nums.size - k) {
           if ((nums[i + k - 1] - nums[i]) < result){
               result = nums[i + k - 1] - nums[i]
            }
        }
        return result
    }
}
