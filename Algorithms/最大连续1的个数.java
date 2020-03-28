public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
		int i=0,r=0,max=0;
		for(i=0;i<nums.length;i++) {
			if(nums[i]==1){
				r++;
			}
			else {
				if(r>max) max=r;
				r=0;
			}
		}
		if(r>max) max=r;
		return max;
    }
}