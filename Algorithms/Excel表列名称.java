public class Solution {
	public String convertToTitle(int n) {
		String ans = new String();
		if(n == 1) return "A";
		while(n != 0) {
			n -= 1;
			ans = ((char)('A'+ n % 26) ) + ans;
			n /= 26;
		}
		return ans;
	}
}