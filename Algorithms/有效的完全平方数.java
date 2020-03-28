public class Solution {
    public boolean isPerfectSquare(int num) {
		int i=0;
		if(num < 0|| num==2147483647) return false;
		for(i = 0;i*i <= num;i++){
			if(i*i == num) return true;
		}
		return false;   
    }
}