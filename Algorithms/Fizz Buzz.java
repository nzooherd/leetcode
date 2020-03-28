public class Solution {
	public List<String> fizzBuzz(int n) {
		List<String> ans = new LinkedList<String>();
		for(int i = 1; i <= n; i++) {
			if(n % 3 != 0 && n % 5 != 0) ans.add(Integer.toString(n));
			else ans.add(number(i));
		}
		return ans;
	}
	public String number(int n) {
		if(n % 3 != 0 && n % 5 != 0) return Integer.toString(n);
		if(n % 3 == 0 && n % 5 == 0) return "FizzBuzz";
		if(n % 3 != 0 && n % 5 == 0) return "Buzz";
		if(n % 3 == 0 && n % 5 != 0) return "Fizz";
		return "0";
	}
}