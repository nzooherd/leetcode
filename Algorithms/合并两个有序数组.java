public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] ans = new int[m+n];
		int i = 0, j = 0;
		int index = 0;
		while(i < m && j < n) {
			if(nums1[i] < nums2[j]) {
				ans[index++] = nums1[i];
				i++;
			}
			else {
				ans[index++] = nums2[j];
				j++;
			}
		}
		if(j < n) {
			for(; j < n; j++){
				ans[index++] = nums2[j];
			}
		}
		if(i < m) {
			for(; i < m; i++) {
				ans[index++] = nums1[i];
			}
		}
		for(int k = 0; k < n+m; k++)
			nums1[k] = ans[k];
    }
}