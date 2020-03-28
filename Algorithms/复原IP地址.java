public class Solution {
    public List<String> restoreIpAddresses(String s) {
		List<String> ans = new ArrayList<String>();
		if(s.length() < 4 || s.length() > 12) return ans;
		for(int i = 0; i < 3; i++) {
			for(int j = i+1; j < i+4 && j < s.length()-1; j++) {
				for(int k = j+1; k < j+4 && k < s.length()-1;k++) {
					if(judge(s,i,j,k)){
						String temp = intToStr(s,i,j,k);
						ans.add(temp);
					}
				}
			}
		}
		return ans; 
    }
	public boolean judge(String s,int x, int y, int z) {
		boolean flag = true;
		flag = 	cmp(s,0,x);
		if(!flag) return flag;
		flag = cmp(s,x+1,y);
		if(!flag) return flag;
		flag = cmp(s,y+1,z);
		if(!flag) return flag;
		flag = cmp(s,z+1,s.length()-1);
		return flag;
	}
	public boolean cmp(String s,int x,int y){
		int temp = 0,i = 0;
		boolean flag = false;
		if(s.charAt(x) == '0' && y != x ) return flag;
		for(i = x; i <= y ; i++) {
			temp *= 10;
			temp += s.charAt(i) - '0';
			if(temp > 255) return flag;
		}
		return true;
	}
	public String intToStr(String s,int x,int y,int z) {
		char[] ip = new char[s.length() + 3];
		int index = 0;
		for(int i = 0; i < ip.length; i++) {
			if(index == x + 1){
				ip[i] = '.';
				i++;
			}
			if(index == y + 1) {
				ip[i] = '.';
				i++;
			}
			if(index == z + 1) {
				ip[i] = '.';
				i++;
			}
			ip[i] = s.charAt(index++);
		}
		String Ip = new String(ip);
		return Ip;
	}
}