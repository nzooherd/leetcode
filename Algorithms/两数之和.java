public class Solution {
    public int[] twoSum(int[] nums, int target) {
		int i=0,j=0;
		int[] r=new int[2];
		mylable:
		for(i = 0;i < nums.length;i++){
			for(j = i+1;j<nums.length;j++){
				if(nums[i] + nums[j] == target) break mylable;
			}
		}
		r[0] = i;
		r[1] = j;
		return  r;
    }
}