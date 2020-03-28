public class Solution {
    public int firstUniqChar(String s) {
		int[] vis = new int[128];
		for(int i = 0; i < s.length(); i++) {
			vis[(int)s.charAt(i)]++;
		}
		for(int i = 0; i < s.length(); i++) {
			if(vis[(int)(s.charAt(i))] == 1) return i;
		}
		return -1;
    }
}