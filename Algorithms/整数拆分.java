public class Solution {
	public int integerBreak(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		if(n <= 2) return dp[n];
		for(int i = 3; i <= n; i++) {
			for(int j = i-1; j > 1; j--) {
				int p = Math.max(j, dp[j]);
				int q = Math.max(i-j, dp[i-j]);
				dp[i] = Math.max(dp[i], p*q);
			}
		}
		return dp[n];
	}
}