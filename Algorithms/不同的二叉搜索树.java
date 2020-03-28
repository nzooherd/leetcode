class Solution {
    public int numTrees(int n) {
        int[] results = new int[n + 1];
        if(n <= 0) return 0;
        if(n == 1 || n == 2) return n;
        results[1] = 1;
        results[2] = 2;
        for(int i = 3; i <= n; i++) {
            for(int j = 1; j <= i; j++){
               if(j == 1 || j == i){
                   results[i] += results[i-1];
               } else {
                   results[i] += results[j - 1] * results[ i - j];
               }
            }
        }
        return results[n];
    }
}