public class Solution {
    public String removeKdigits(String num, int k) {
		int[] nums = new int[num.length()];
		int[] vis = new int[nums.length];
		char[] ans = new char[nums.length - k];
		for(int i = 0; i < num.length(); i++) 
			nums[i] = num.charAt(i) - '0';	
		if(k >= nums.length) return "0";
		int flag = 0, temp = 0, min = 0;
		while(k != 0) {
			min = 10;
			if(flag + k + 1 <= nums.length) {
			    for(int i = flag; i < flag+k+1 ; i++) {
				    if(min > nums[i]) {
					    min = nums[i];
					    temp = i;
				    }
			    }
			    for(int j = flag; j < temp; j++) {
			        System.out.println(j);
				    vis[j] = 1;
			    }
			}
			else {
			    for(int j = flag; j < nums.length; j++)
			        vis[j] = 1;
			    break;
			}
			k -= (temp - flag);
			flag = temp + 1;
		}
		int index = 0;
		flag = 0;
		for(int i = 0; i < nums.length; i++) {
			if(vis[i] == 0 ) {
				if(nums[i] != 0) {
					ans[index++] = (char)(nums[i] + '0');
					flag = 1;
				}
				else {
					if(flag == 0) ;
					else {
						ans[index++] = (char)(nums[i] + '0');
					}

				}
			}
		}
		if(index == 0) return "0";
		char[] r = new char[index];
		for(int i = 0; i < index; i++) 
			r[i] = ans[i];
		return new String(r);
    }
}