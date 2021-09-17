class Solution {
    fun splitArray(nums: IntArray, m: Int): Int {
        val dp = Array(nums.size) { _ -> IntArray(m) { _ -> -1 } }
        for (i in dp.indices) {
            for (j in 0 until m) {
                if(j == 0){
                    dp[i][j] = nums.slice(0..i).sum()
                    continue
                }
                if(j > i){
                    dp[i][j] = -1
                    continue
                }else if(i == j){
                    dp[i][j] = nums.slice(0..i).max()!!
                    continue
                }
                var curSum = nums[i]
                var end = i - 1
                while(end > 0 && dp[end][j-1] > curSum){
                    curSum += nums[end]
                    end -= 1
                }
                dp[i][j] = minOf(maxOf(dp[end][j-1], curSum), maxOf(dp[end+1][j-1], curSum - nums[end+1]))
            }
        }
        return dp[nums.size - 1][m - 1]
    }
}