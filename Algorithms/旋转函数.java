public class Solution {
    public int maxRotateFunction(int[] A) {
		if(A.length == 0) return 0;
		long sum = 0;
		int max = 0x80000000, temp = 0;
		for(int i:A){
			sum += i;
		}
		for(int i = 0; i < A.length; i++) {
			temp += i*A[i];
		}
		if(temp > max) max = temp;
		for(int i = 0; i < A.length-1; i++) {
			temp += (sum - A.length*A[A.length-1-i]);
			if(temp > max) max = temp;
		}
		return max; 
    }
}