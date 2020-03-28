public class Solution {
    public int totalHammingDistance(int[] nums) {
		if(nums.length == 0 || nums.length == 1) return 0;
		int ans = 0, count1 = 0, count0 = 0, flag = 1;
		int max = 0;
		for(int i = 0; i < nums.length; i++)
			max = Math.max(max, nums[i]);
		while(flag <= max) {
			count0 = 0;
			count1 = 0;
			for(int i = 0; i < nums.length; i++) {
				if((nums[i] & flag) == flag) count1++;
				else count0++; 
			}
			System.out.println(count1);
			System.out.println(count0);
			ans += count0 * count1;
			flag <<= 1;
		}
		return ans; 
    }
}