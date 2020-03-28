public class Solution {
    public boolean isHappy(int n) {
		boolean r = false;
		int x=n,y=n;
		while(n > 1){
			x = cal(x);
			if(x == 1) return true;
			y = cal(cal(y));
			if(y == 1) return true;
			if(y == x) return false;
		}
		return true; 
    }
	public int cal(int n){
		int temp = 0;
		while(n != 0){
			temp += Math.pow(n%10,2);
			n /= 10;
		}
		return temp;
	}
}