public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
		if(z == 0) return true;
	    if(x == 0 || y == 0){
			if( z == x || z== y) return true;
			else return false;
		}
		if(x > y){
		    x = x^y;
		    y = y^x;
		    x = x^y;
		}
		if(z > (x+y)) return false;
		if(z % gcd(x,y) == 0) return true;
		return false;
    }
	public int gcd(int x, int y) {
		if(y % x == 0) return x;
		else {
			return gcd(y % x, y);
		}
	}
}