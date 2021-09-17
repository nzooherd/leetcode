class Solution {
    public int[] sortedSquares(int[] A) {
        if(A == null || A.length == 0){
            return null;
        }
    	int[] res = new int[A.length];
    	if(A[0] >= 0){
    		for(int i = 0; i < A.length; i++){
    			res[i] = A[i] * A[i];
    		}
    		return res;
    	}
    	if(A[A.length - 1] <= 0){
    		for(int i = A.length - 1; i >= 0; i--){
    			res[A.length - i - 1] = A[i] * A[i];
    		}
    		return res;
    	}

    	int left = 0, right = 1, count = 0;
    	while(A[left] * A[right] > 0){
    		left++;
    		right++;
    	}
    	while(left >= 0 && right < A.length) {
    		if(-A[left] < A[right]){
    			res[count] = A[left] * A[left];
    			left -= 1;
    		}else{
    			res[count] = A[right] * A[right];
    			right += 1;
    		}
            count++;
    	}
    	while(left >= 0){
    		res[count] = A[left] * A[left];
    		left -= 1;
            count++;
    	}
    	while(right < A.length){
    		res[count] = A[right] * A[right];
            count++;
    		right += 1;
    	}
    	return res;

    }
}