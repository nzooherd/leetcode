public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly=new int[n];
		ugly[0] = 1;
		int i=0,j=0,k=1,min=100;
		int[] index=new int[primes.length];
		for(i=0;i<primes.length;i++) index[i]=0;
		int[] factor=new int[primes.length];
		for(i=0;i<primes.length;i++) factor[i]=primes[i];
		for(i=1;i<n;i++){
			min = factor[0];
			for(j=0;j<primes.length;j++){
				if(factor[j]<min) min=factor[j];
			}
			ugly[k++] = min;
			for(j=0;j<primes.length;j++){
				if(min == factor[j]) {
					factor[j] = primes[j]*ugly[(++index[j])];
				}
			}		
		}
		return ugly[n-1];
    }
}