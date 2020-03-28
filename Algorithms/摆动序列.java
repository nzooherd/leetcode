public class Solution {
    public int wiggleMaxLength(int[] nums) {
		if(nums.length <= 1) return nums.length;
		int flag = nums[0],cnt = 1,tp = 0;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == flag) continue;
			if(tp == 0){
				if(flag < nums[i]) tp = -1;
				else tp = 1;
				flag = nums[i];
				cnt++;
			}
			else if(nums[i] > flag ) {
				if(tp == -1) flag = nums[i];
				else {
					cnt++;
					tp = -1;
					flag = nums[i];
				}
			}
			else{
				if(tp == 1) flag = nums[i];
				else{
					flag = nums[i];
					cnt++;
					tp = 1;
				}
			}
			
		}
		return cnt;
    }
}