class Solution {
    public int findLength(int[] A, int[] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0) return 0;
        int[][] ret = new int[A.length][B.length];
        int max = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++) {
                if(A[i] == B[j]) {
                    ret[i][j] = j > 0 ? (i > 0 ? ret[i-1][j-1] + 1 : 1) : 1;
                    max = Math.max(ret[i][j], max);
                } else {
                    ret[i][j] = 0;
                }
            }
        }
        return max;
    }
}