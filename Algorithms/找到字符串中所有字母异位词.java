public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
		List<Integer> ans = new ArrayList<Integer>();
		if(s.length() < p.length()) return ans;
		int number = 0, temp = 0;
		for(int i = 0; i < p.length(); i++) {
			number += p.charAt(i) - 'a';
		}
		for(int i = 0; i < p.length(); i++) {
			temp += s.charAt(i) - 'a';
		}
		if(judge(temp, number, 0, p.length()-1, s, p)) ans.add(0);
		for(int i = 1; i + p.length() <= s.length(); i++) {
			int j = i + p.length() - 1;
			temp -= s.charAt(i-1) - 'a';
			temp += s.charAt(j) - 'a';
			if(judge(temp, number, i, j, s, p)) ans.add(i);			
		}		
		return ans; 
    }
	public boolean judge(int a, int number, int i, int j, String s, String p) {
		if(a != number) return false;
		int[] vis = new int[26];
		int index = 0;
		for(; i <= j; i++) {
			vis[s.charAt(i) - 'a']++;
			vis[p.charAt(index++) - 'a']--;
		}
		for(int x : vis)
			if(x != 0) return false;
		return true;
	}
}