public class Solution {
    public boolean isAnagram(String s, String t) {
		int i=0;
		int[] a=new int[60];
		int[] b=new int[60];
		if(s.length() != t.length()) return false;
		for(i = 0;i < s.length(); i++ ) {
			a[(int)s.charAt(i)-(int)'A']++;
			b[(int)t.charAt(i)-(int)'A']++;
		}
		for(i = 0;i < 60;i++) {
			if(a[i] != b[i]) return false;
		}
		return true;
 
    }
}