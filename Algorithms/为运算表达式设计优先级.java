public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return diffWaysToComputer(input); 
    }
	public ArrayList<Integer> diffWaysToComputer(String input) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int temp = 0,count = 0;
		for(int i = 0; i < input.length(); i++) {
			if(judge(input.charAt(i))) count++;
		}
		if(count == 0) {
			temp = strToint(input,0,input.length()-1);
			ans.add(temp);
			return ans;
		}
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) < '0' || input.charAt(i) > '9') {
				String p = input.substring(0,i);
				String q = input.substring(i+1,input.length());
				ArrayList<Integer> pre = diffWaysToComputer(p);
				ArrayList<Integer> qur = diffWaysToComputer(q);
				List<Integer> tp = conquer(pre,qur,input.charAt(i));
				ans.addAll(tp);
			}
		}
		return ans;
	}
	public ArrayList<Integer> conquer(ArrayList<Integer> a,ArrayList<Integer> b,char x) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int temp = 0;
		for(int i = 0; i < a.size(); i++) {
			for(int j = 0; j < b.size(); j ++) {
				temp = aco(a.get(i),b.get(j),x);
				ans.add(temp);
			}
		}
		return ans;
	}
	public int 	aco(int x, int y, int z) {
		int ans = 0;
		if(z == '-') ans = x - y;
		else if(z == '+') ans = x + y;
		else ans = x * y;
		return ans;
	}
	public boolean judge(char x) {
		if(x > '9' || x < '0') return true;
		return false;
	}
	public int strToint(String s,int st,int ed) {
		int ans = 0;
		for(int i = st; i <= ed; i++) {
			ans *= 10;
			ans += s.charAt(i) - '0';
		}
		return ans;
	}
}