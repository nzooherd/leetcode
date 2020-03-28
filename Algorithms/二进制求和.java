public class Solution {
    public String addBinary(String a, String b) {
		int length = a.length()>b.length()?a.length():b.length()+1;
		if(a.length() > b.length()) {
			char[] bt = new char[a.length()-b.length()];
			for(int i = 0; i < bt.length; i++) {
				bt[i] = '0';
			}
			String btemp = new String(bt);
			b = btemp.concat(b);
			System.out.println("b="+b);
		}
		if(b.length() > a.length()) {
			char[] at = new char[b.length()-a.length()];
			for(int i = 0; i < at.length; i++) {
				at[i] = '0';
			}
			String atemp = new String(at);
			a = atemp.concat(a);
		}
		char[] ans = new char[a.length()+1];
		int temp = 0, ct = 0;
		for(int i = a.length()-1;i >= 0; i--){
			temp = a.charAt(i) - '0' + b.charAt(i) - '0';
			temp += ct;
			ct = temp/2;
			temp %= 2;
			ans[i+1] = (char)(temp + '0');		
		}
		ans[0] = (char)(ct + '0');
		String r = new String(ans);
		if(ans[0] == '0') r = r.substring(1);
		return r;
    }
}