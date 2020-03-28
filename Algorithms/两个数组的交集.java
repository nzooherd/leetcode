public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> map = new HashSet<Integer>();
		HashSet<Integer> r = new HashSet<Integer>();
		for(int i : nums1) {
			map.add(i);
		}
		for(int i : nums2) {
			if(map.contains(i)) r.add(i);
		}
		int[] ans = new int[r.size()];
		int index = 0;
		for(Integer i : r)
			ans[index++] = i;
		return ans;
    }
}