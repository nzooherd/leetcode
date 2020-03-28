public class Solution {
	public String largestNumber(int[] nums){
		if(nums == null) return null;
		String[] stringNum = new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
			stringNum[i] = Integer.toString(nums[i]);
		}
		String ans = new String();
		StringBuffer sb = new StringBuffer();
		Arrays.sort(stringNum, new Comparator<String>(){
			public int compare(String s1, String s2){ 
				return 0-(s1+s2).compareTo(s2+s1);
			}

		}
		);
		for(int i = 0; i < stringNum.length; i++) {
			sb.append(stringNum[i]);
		}
		int flag = 0;
		for(int i = 0; i < sb.length()-1; i++) {
			if(sb.charAt(i) != '0') {
				flag = i;
				break;
			}
			flag++;
		}
		return sb.substring(flag, sb.length()).toString();

	}
}