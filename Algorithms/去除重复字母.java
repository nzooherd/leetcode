public class Solution {
    public String removeDuplicateLetters(String s) {
		if(s == null || s.length() == 0) return new String();
		int[] map = new int[26];
		int[] vis = new int[26];
		int  count = 0, flag = 0, index = 0;
		char min = 'z'+1;
		for(int i = 0; i < s.length(); i++) {
			map[s.charAt(i) - 'a']++;
			if(map[s.charAt(i) - 'a'] >= 2) count++;
		}
		char[] r = new char[s.length() - count];
		int temp = 0;
		for(int i = 0; i < s.length(); i++){
			min = 'z'+1;
			while(i < s.length() && --map[s.charAt(i) - 'a'] >= 0) {
				if(vis[s.charAt(i) - 'a'] == 1) {
						i++;
						continue;
				}
				if(min > s.charAt(i)) {
					min = s.charAt(i);
					flag = i;
				}
				if(map[s.charAt(i) - 'a'] == 0) break;
				i++;
			}
			for(int j = flag+1; j <= i; j++)
				map[s.charAt(j) - 'a']++;
			r[index++] = s.charAt(flag);
			vis[s.charAt(flag) - 'a'] = 1; 
			if(index == r.length) break;
			temp = flag;
			i = flag;
		}
		return new String(r);
    }
}