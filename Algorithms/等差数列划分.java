public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
		int sum=0,i=0,n=0;
		if(A.length<3) return sum;
		for(i=2;i<A.length;i++){
			if(A[i]+A[i-2] == 2*A[i-1]){
				n++;
			}
			else{
				sum += (n+1)*n/2;
				n = 0;
			}
		}
		return sum+(n+1)*n/2;

    }
}