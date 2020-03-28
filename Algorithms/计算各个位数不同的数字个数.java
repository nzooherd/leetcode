public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
		if(n > 10) n = 10;
		int sum = 0;
		for(int i = 1; i <= n; i++)
			sum += f(i);
		return sum;
    }
	public int f(int x) {
		if(x == 1) return 10;
		else{
			int sum = 9, n = 9;
			while(x-- != 1) {
				sum *= n;
				n--;
			}	
			return sum;
		}
	}
}