public class Solution {
	public int nextGreaterElement(int n) {
		int ans = 0;
		int count = 0,flag = 0, index = 0, min = 10;
		for(long i = 1; n >= i; i *= 10)
			count++;
		if(count == 1) return -1;
		int[] digits = new int[count];
		while(n != 0){
			digits[index++] = n%10;
			n /= 10;
		}
		for(int i = 0; i < count/2; i++){
			int temp = digits[i];
			digits[i] = digits[count - i - 1];
			digits[count - i - 1] = temp;
		}
		for(int i = count-1; i >= 0; i--) {
			for(int j = i+1; j < count; j++) {
				if(digits[j] > digits[i]) {
					if(digits[j] < min) {
						min = digits[j];
						flag = j;
					}
				}
			}
			if(flag != 0) {
				int temp = digits[i];
				digits[i] = digits[flag];
				digits[flag] = temp;
				flag = i;
        		Arrays.sort(digits, flag+1, digits.length);
        		for(int k = 0; k < digits.length; k++){
        		    int tempans = ans;
        			ans *= 10;
        			if(ans / 10 != tempans) return -1;
        			ans += digits[k];
        		}
        		return ans;
			}
		}
		return -1;
	}
}