public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		int[] flag = new int[nums.length+1];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i : nums)
			flag[i] = 1;
		for(int i = 0; i < nums.length; i++){
			if(flag[i+1] == 0) 
				ans.add(i+1);
		}
		return ans;
    }
}