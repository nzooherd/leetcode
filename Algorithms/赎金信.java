public class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] vis = new int[26];
		for(int i = 0; i < 26; i++) vis[i] = 0;
		if(ransomNote.length() > magazine.length()) return false;
		for(int i = 0; i < magazine.length(); i++){
			if(i < ransomNote.length()) vis[ransomNote.charAt(i) - 'a']--;
			vis[magazine.charAt(i) - 'a']++;
		}
		for(int i = 0; i < 26; i++)
			if(vis[i] < 0) {
			    System.out.println(i);
			    return false;
			}
		return true;
	}
}