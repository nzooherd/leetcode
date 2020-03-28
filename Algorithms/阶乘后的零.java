public class Solution {
    public int trailingZeroes(int n) {
		int r = 0,temp = 5 ;
		while(n > 0) {
			r += n/5;
			n /= 5;
		}
		return r;
    }
}