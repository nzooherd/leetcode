public class Solution {
    public int arrayNesting(int[] nums) {
		int[] map = new int[nums.length];
		int[] vis = new int[nums.length];
		int flag = 0, max = 0, index = 0;
		for(int i = 0; i < nums.length; i++) {
			while(vis[i] == 0) {
				map[index++] = i;
				vis[i] = 1;
				i = nums[i];
				max = Math.max(index - flag, max);
			}
			flag = index;
		}
		return max;
    }
}