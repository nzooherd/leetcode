public class Solution {
	public boolean checkRecord(String s) {
		int flagA = 0, flagL = 0, count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'A') flagA++;
			if(s.charAt(i) == 'L') {
				count++;
				if(count > 2) return false;
			}
			else count = 0;
			if(flagA > 1) return false;

		}
		return true;
	}
}