public class Solution {
    public int thirdMax(int[] nums) {
		int min = nums[0];
		for(int i : nums) min = Math.min(min, i);
		int max1 = min, max2 = min, max3 = min; 
		int flag = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] >= max1) max1 = nums[i];
		}
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == max1) continue;
			if(nums[i] >= max2) max2 = nums[i];
		}
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] >= max2) continue;
			if(nums[i] >= max3) {
				flag = 1;
				max3 = nums[i];
			}
		}
		if(flag == 0) return max1;
		return max3;
   
    }
}