public class Solution {
    public int[] countBits(int num) {
		int[] r = new int[num+1];
		int i = 0,pow = 1;
		for(i = 0;i <= num;i++){
			if(i == 0) r[i] = 0;
			else {
				r[i] = r[i-pow]+1;
			}
			if(i+1 == pow*2) pow *= 2;
		}
		return r;
		}
}