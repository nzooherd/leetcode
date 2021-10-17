class Solution {
    fun areNumbersAscending(s: String): Boolean {
        val tokens = s.split(" ") 
        val nums = mutableListOf<Int>()
        for (token in tokens) {
            try {
                val num = Integer.valueOf(token)
                nums.add(num)
            } catch (e: Exception) {
                
            }
        }
        
        for (i in 0 until nums.size - 1) {
            if (nums[i] >= nums[i+1]) {
                return false
            }
        }
        return true 
    }
}