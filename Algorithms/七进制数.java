public class Solution {
    public String convertToBase7(int num) {
		if(num == 0) return "0";
		boolean flag = num >0;
		String r ="";
		while(num != 0){
			r = Math.abs((num%7)) + r;
			num /= 7;
		}
		return flag ? r : "-"+r;

    }
}