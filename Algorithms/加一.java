public class Solution {
    public int[] plusOne(int[] digits) {
		int[] result=new int[digits.length+1];
		int i=0;
		for(i=0;i<digits.length;i++){
			result[i+1] = digits[i];
		}
		result[i] += 1;
		for(i=digits.length;i>0;i--){
			result[i-1] += result[i]/10;
			result[i] %= 10;
		}
		if(result[0] == 1) return result;
		for(i=0;i<digits.length;i++)
			digits[i] = result[i+1];
		return digits;  
    }
}