public class Solution {
    public int maxCoins(int[] nums) {
		int[] map = new int[nums.length+2];
		int index = 0;
		map[index++] = 1;
		for(int i : nums) map[index++] = i;
		map[index++] = 1;
		int[][] dp = new int[index][index];
		for(int i = 2; i < index; i++) {
			for(int left = 0; left+i < index; left++){
				int right = left+i;
				for(int k = left+1; k < right; k++){
					dp[left][right] = Math.max(dp[left][right],map[left]*map[right]*map[k]+dp[left][k]+dp[k][right]);
				}
			}	
		}
		return dp[0][index-1];
    }
}