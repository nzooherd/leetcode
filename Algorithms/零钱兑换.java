public class Solution {
    public int coinChange(int[] coins, int amount) {
		int[][] dp = new int[coins.length][amount+1];
		for(int i = 1; i <= amount; i++){
			if(i % coins[0] == 0) dp[0][i] = i / coins[0];
			else dp[0][i] = 214748;
		}
		for(int i = 1; i < coins.length; i++) {
			for(int j = 1; j <= amount; j++) {
				if(j >= coins[i] ){
					dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i]]+1);
				}
				else dp[i][j] = dp[i-1][j];
			}
		}
		if(dp[coins.length-1][amount] >= 214748) return -1;
		return dp[coins.length-1][amount];
    }
}