public class Solution {
    public int[] productExceptSelf(int[] nums) {
		int[] r=new int[nums.length];
		int sum = 1,i=0,count=0;
		for(i = 0;i<nums.length;i++){
			if(nums[i]!=0) sum *= nums[i];
			else count++;
		}
		if(count <= 1){
			for(i = 0;i<nums.length;i++){
				if(nums[i]!=0&&count == 1) r[i] = 0;
				else if(nums[i]!=0&&count==0) r[i] = sum/nums[i];
				else r[i] = sum;
			}
		}
		else ;
		return r;
    }
}