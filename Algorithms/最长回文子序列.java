public class Solution {
    public int longestPalindromeSubseq(String s) {
		char[] p = new char[s.length()];
		for(int i = 0; i < s.length(); i++) {
			p[i] = s.charAt(s.length()-i-1);
		}
		String x = new String(p);
		System.out.println(p);
		int[][] dp = new int[s.length()][s.length()];
		int flag = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == x.charAt(0)) flag = 1;
			if(flag == 1) dp[i][0] = 1;
			else dp[i][0] = 0;
		}
		flag = 0;
		for(int i = 0; i < s.length(); i++) {
			if(x.charAt(i) == s.charAt(0))   flag = 1;
			if(flag == 1) dp[0][i] = 1;
			else dp[0][i] = 0;
		}
		for(int i = 1; i < s.length(); i++)
			for(int j = 1; j < s.length(); j++){
				if(s.charAt(i) == x.charAt(j)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		return dp[s.length()-1][s.length()-1];
    }
}