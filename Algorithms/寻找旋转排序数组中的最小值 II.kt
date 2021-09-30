class Solution {
    fun findMin(nums: IntArray): Int {
        return findMin(nums, 0, nums.size - 1)
    }
    fun findMin(nums: IntArray, start: Int, end: Int): Int {
        var left = start; var right = end;
        while (left <= right) {
            if (nums[left] < nums[right]) {
                return nums[left]
            }
            val mid = (left + right) / 2
            if (nums[mid] > nums[left]) {
                left = mid + 1
            } else if (nums[mid] < nums[left]) {
                right = mid
            } else {
                if (nums[mid] > nums[right]) {
                    left = mid + 1
                } else if (nums[mid] < nums[right]) {
                    right = mid
                } else {
                    if (left == right) {
                        return nums[left]
                    } else {
                        return findMin(nums, left, mid).coerceAtMost(findMin(nums, mid + 1, right))
                    }
                }
            }
        }
        return -1
    }
}