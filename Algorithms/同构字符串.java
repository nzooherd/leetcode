public class Solution {
    public boolean isIsomorphic(String s, String t) {
		int[] map = new int[128];	
		int[] vis = new int[128];
		for(int i = 0; i < 128; i++)
			map[i] = -1;
		if(s.length() != t.length()) return false;
		for(int i = 0; i < s.length(); i++) {
			if(map[s.charAt(i)] == -1) {
				if(vis[t.charAt(i)] == 1) return false;
				map[s.charAt(i)] = (int)(t.charAt(i));
				vis[t.charAt(i)] = 1;
			}
			else {
				if(t.charAt(i) != map[s.charAt(i)]) return false;
			}
		}
		return true;
    }
}