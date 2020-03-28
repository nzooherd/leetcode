public class Solution {
	public int minDistance(String word1, String word2) {
		if(word1.length() == 0) return word2.length();
		if(word2.length() == 0) return word1.length();
		int leg1 = word1.length();
		int leg2 = word2.length();
		int[][] dp = new int[leg1][leg2];
		for(int i = 0; i < leg2; i++) {
			if(word2.charAt(i) == word1.charAt(0)) {
				for(; i < leg2; i++)
					dp[0][i] = 1;
			}
		}
		for(int i = 0; i < leg1; i++) {
			if(word1.charAt(i) == word2.charAt(0)) {
				for(; i < leg1; i++)
					dp[i][0] =1;
			}
		}
		for(int i = 1; i < leg1; i++) {
			for(int j = 1; j < leg2; j++) {
				if(word1.charAt(i) == word2.charAt(j)) 
					dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		return leg1 + leg2 - dp[leg1-1][leg2-1]*2;
	}
}