public class Solution {
    public String addStrings(String num1, String num2) {
		int[] nub1 = new int[num1.length()];
		int[] nub2 = new int[num2.length()];
		int length = Math.max(nub1.length, nub2.length);
		int[] num = new int[length+1];
		strToint(num1, nub1);
		strToint(num2, nub2);
		add(nub1, nub2, num);
		if(num[0] != 0) length++;
		char[] ans = new char[length];
		int index = 0;
		for(int i = 0; i < num.length; i++) {
			if(i == 0 && num[i] == 0) continue;
			ans[index++] = (char) ('0' + num[i]);
			System.out.println(index);
		}
		return new String(ans); 
    }
	public void strToint(String num, int[] ans) {
		for(int i = 0; i < num.length(); i++) {
			ans[i] = num.charAt(i) - '0';
		}
	}
	public void add(int[] num1, int[] num2, int[] num) {
		if(num1.length == num2.length) {
			for(int i = num1.length-1; i >= 0; i--) {
				num[i+1] += num1[i] + num2[i];
				num[i] += num[i+1]/10;
				num[i+1] %= 10;
			}
		}
		else if(num1.length < num2.length) {
			int index = num.length-1;
			int temp = num2.length - num1.length;
			for(int i = num1.length-1; i >= 0; i--) {
				num[index] += num1[i] + num2[i + temp];
				num[index-1] += num[index]/10;
				num[index] %= 10;
				index--;
			}
			for(int j = temp-1; j >= 0; j--) {
				num[index] += num2[j];
				num[index-1] += num[index]/10;
				num[index] %= 10;
				index--;
			}
		}
		else {
			int index = num.length-1;
			int temp = num1.length - num2.length;
			for(int i = num2.length-1; i >= 0; i--) {
				num[index] += num1[i + temp] + num2[i];
				num[index-1] += num[index]/10;
				num[index] %= 10;
				index--;
			}
			for(int j = temp-1; j >= 0; j--) {
				num[index] += num1[j];
				num[index-1] += num[index]/10;
				num[index] %= 10;
				index--;
			}
		}

	}
}