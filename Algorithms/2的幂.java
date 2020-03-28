public class Solution {
    public boolean isPowerOfTwo(int n) {
		boolean r = false;
		if(n <= 0) return r;
		while(n != 1){
			if(n%2 == 1) break;
			n /= 2;
		}
		if(n == 1) r = true;
		else r = false;
		return r;
    }
}