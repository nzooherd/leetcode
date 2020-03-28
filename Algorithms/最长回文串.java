public class Solution {
    public int longestPalindrome(String s) {
		int[] cNum=new int[60];
		int flag = 0, r = 0,i = 0;
		for(i = 0 ; i < s.length() ;i++) {
			cNum[(int)s.charAt(i)-(int)'A']++;
		}
		for(i = 0; i < 60 ;i++){
			if(flag == 0 && cNum[i]%2 == 1) flag = 1;
			r += (cNum[i]-cNum[i]%2);
		}
		r += flag;
		return  r;   
    }
}