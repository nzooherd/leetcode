public class Solution {
    public boolean isPowerOfThree(int n) {
			while(n!= 0 &&n!= 1&&n%3 == 0){
				n /= 3;
			}
			if(n == 1) return true;
			else return false;
    }
}