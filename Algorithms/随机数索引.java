public class Solution {
	private HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
    public Solution(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.get(nums[i]).add(i);
			}
			else {
				ArrayList<Integer> temp = new ArrayList<Integer>(1);
				temp.add(i);
				map.put(nums[i],temp);
			}

		}
    }
    
    public int pick(int target) {
        Random random = new Random();
		return map.get(target).get(random.nextInt(map.get(target).size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */