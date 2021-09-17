class Solution {
    fun kthLargestNumber(nums: Array<String>, k: Int): String {
        nums.sortWith(Comparator { str1: String, str2: String -> when {
            str1.length < str2.length -> 1
            str1.length > str2.length -> -1
            else ->  -compareValues(str1, str2)
        }})
        return nums[k - 1]
    }
}