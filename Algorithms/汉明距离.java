public class Solution {
    public int hammingDistance(int x, int y) {
		int r=0,temp=0;
		temp = x^y;
		while(temp>0){
			temp &= (temp-1);
			r++;
		}
		return r;
    }
}