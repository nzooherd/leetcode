class Solution {
    public int longestMountain(int[] A){
        int ret = 0;
        int l = 0, r = 1;
        if(A == null || A.length < 3) return 0;
        while(r < A.length) {
            if(A[r] <= A[l]) {
                l++;
                r++; 
                continue;
            }
            int tempL = l, flag = 1;
            while(r < A.length) {
                l++;
                r++;
                if(flag == -1) {
                    if((r - tempL) > ret) {
                        ret = r - tempL;
                    }
                }
                if(r == A.length) break;
                if(A[r] > A[l] && flag == 1) {
                }else if(A[r] > A[l] && flag == -1) {
                    break;
                } else if(A[r] < A[l] && flag == 1) {
                    flag = -1;
                } else if(A[r] < A[l] && flag == -1) {
                } else if(A[r] == A[l]) {
                    break;
                }

            }
        }
        return ret;
    }
}