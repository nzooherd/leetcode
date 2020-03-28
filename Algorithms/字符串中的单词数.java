public class Solution {
    public int countSegments(String s) {
		int cnt = 0,flag = 0;
		for(int i = 0; i < s.length(); i++){
			if(flag == 0 && s.charAt(i) != ' ') {
			    flag = 1;
			    cnt++;
			}
			if(flag == 1 && s.charAt(i) == ' ') {
				flag = 0;
			}
		}
		return cnt;
    }
}