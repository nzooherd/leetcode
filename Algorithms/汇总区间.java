public class Solution {
    public List<String> summaryRanges(int[] nums) {
		List<String> ans = new ArrayList<String>();
		int flag = 0;
		for(int i = 0; i < nums.length; i++) {
			StringBuffer temp = new StringBuffer();
			flag = i;
			temp.append(Integer.toString(nums[i]));
			while(i+1 < nums.length && nums[i+1] - nums[i] == 1) {
				i++;
			}
			if(i != flag) {
				temp.append("->");
				temp.append(Integer.toString(nums[i]));
			}
			ans.add(temp.toString());
		}
		return ans;
    }
}