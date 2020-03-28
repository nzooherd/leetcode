public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
		if((m^n)>m) return 0;
		if(m==0 && n==0) return 0;
		if(m==n) return m;
		int temp=m^n;
		while(temp != 1){
			m >>= 1;
			temp >>= 1;
		}
		m >>= 1;
		while((m^n)>m){
			m <<= 1;
		}
		return m;
    }
}