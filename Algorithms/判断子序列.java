public class Solution {
    public boolean isSubsequence(String s, String t) {
		boolean flag = false;
		if(s.length() == 0) return true;
		int indexS = 0,indexT = 0;
		while(indexS <= s.length()-1 && indexT <= t.length()-1){
			if(t.charAt(indexT) == s.charAt(indexS)){
				indexS++;
			}
			indexT++;
		}
		if(indexS == s.length()) flag = true;
		else ;
		return flag;
    }
}