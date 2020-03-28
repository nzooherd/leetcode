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
		for(int i = 2; i < nums.length; i++) {
			for(int j = 0; i + j < nums.length; j++){
				int temp = 0;
				for(int k = j; k <= j+i; k++){
					if(j !=0 || i != nums.length-1){
						if(k-1 >=0 && k+1 < nums.length) temp = Math.max(temp,dp[j][k-1]+dp[k+1][j+i]);
						else if(k-1 < 0) temp = Math.max(temp,dp[k+1][j+i]);
						else temp = Math.max(temp,dp[j][k-1]);
					}
					else{
						if(k == 0) temp = Math.max(temp,dp[1][j+i]);
						else if(k == nums.length-1) temp = Math.max(temp,dp[0][k-1]);
						else{
							temp = Math.max(temp,dp[1][k-1]+dp[k+1][j+i]);
							temp = Math.max(temp,dp[0][k-1]+dp[k+1][j+i-1]);
						}
					}	
				}
				dp[j][j+i] = temp;
				System.out.println(dp[j][j+i]);
			}
		}
		return dp[0][nums.length-1];
    }
}