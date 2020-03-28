public class Solution {
    public List<Integer> countSmaller(int[] nums) {
 		List<Integer> r = new ArrayList<Integer>();
		if(nums.length == 0) return r;
		int[] ans = new int[nums.length];
		ans[nums.length-1] = 0;
		for(int i = nums.length-2; i >= 0; i--) {
			int temp = nums[i], j = 0;
			for(j = i+1; j < nums.length && nums[j] >= temp ; j++) {
				nums[j-1] = nums[j];
			}
			nums[j-1] = temp;
			ans[i] = nums.length - j ;
		}
		for(int i : ans)
			r.add(i);
		return r;
    }
}