public class Solution {
    public int findComplement(int num) {
		int r = 0,temp = 1;
		while(num != 0){
			if ((num & 1) == 0) {
				r += temp;
			}
			num >>= 1;
			temp *= 2;
		}
		return r;
	}
}