public class Solution {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++) {
			int temp = nums[i]-1;
			if(nums[i] < 0) temp = 0 - nums[i] - 1;
			if(nums[temp] < 0) ans.add(temp+1);
			else nums[temp] *= -1;
		}
		return ans;
	}
}