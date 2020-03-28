class Solution {
    public boolean isScramble(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        if(cs1.length != cs2.length) return false;
        int[][][] dp = new int[cs1.length][cs2.length][cs2.length];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp.length; j++){
                for(int k = 0; k < dp.length; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return process(cs1, cs2, 0, 0, cs1.length, dp);
    }
    public boolean process(char[] cs1, char[] cs2, int l1, int l2, int size, int[][][] dp){
        if(dp[l1][l2][size-1] != -1) {
            return dp[l1][l2][size-1] == 1;
        }
        if(size == 1){
            dp[l1][l2][size-1] = cs1[l1] == cs2[l2] ? 1 : 0;
            return cs1[l1] == cs2[l2];
        }
        for(int i = 1; i < size ; i++){
           if(process(cs1, cs2, l1, l2, i, dp) && process(cs1, cs2, l1+i, l2+i, size - i, dp) ||
                process(cs1, cs2, l1, l2 + size - i, i, dp) && process(cs1, cs2, l1 + i, l2, size - i, dp)){
                dp[l1][l2][size-1] = 1;
                return true;
           }
        }
        dp[l1][l2][size-1] = 0;
        return false;

    }
}