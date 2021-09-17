class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int left = 0, right = 1;
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0){
                res[left] = A[i];
                left += 2;
            }else{
                res[right] = A[i];
                right += 2;
            }
        }
        return res;
    }
}