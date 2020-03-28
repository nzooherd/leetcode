public class Solution {
    public void moveZeroes(int[] nums) {
		int i=0,index=0;
		int[] temp=new int[nums.length];
		for(i=0;i<nums.length;i++){
			if(nums[i] == 0) continue;
			temp[index++] = nums[i];
		}
		for(i=0;i<index;i++){
			nums[i] = temp[i];
		}
		for(;i<nums.length;i++)
			nums[i] = 0;
    }
}