public class Solution {
    public int rob(int[] nums) {
		if(nums.length <= 0) {
			return 0;
		}
		int[][] dp = new int[nums.length][nums.length];
		for(int i = 0; i < nums.length; i++) {
			dp[i][i] = nums[i];
		}
		for(int i = 0; i < nums.length-1; i++) {
			dp[i][i+1] = Math.max(dp[i][i],dp[i+1][i+1]);
		}
		for(int i = 0; i < nums.length; i++) {
			for(int j = 2; i +j < nums.length; j++) {
				int temp = 0;
				for(int k = i; k <= j; k++){
					if(k-1 >=0 && k+1 < nums.length) temp = Math.max(temp,dp[i][k-1]+dp[k+1][j]);
					else if(k-1 < 0) temp = Math.max(temp,dp[k+1][j]);
					else temp = Math.max(temp,dp[i][k-1]);
				}
				dp[i][j] = temp;	
			}
		}
		return dp[0][nums.length-1]; 
    }
}