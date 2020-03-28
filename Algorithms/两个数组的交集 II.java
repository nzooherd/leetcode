public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
		int i=0,k=0,index=0;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int[] r=new int[nums1.length>nums2.length?nums1.length:nums2.length];
		for(i=0;i<nums1.length&&k<nums2.length;i++) {
			while(k<nums2.length&&nums2[k]<nums1[i]) {
				k++;
			}
			if(k<nums2.length&&nums2[k] == nums1[i]) {
				r[index++] = nums2[k];
				k++;
			}
		}
		int[] z=new int[index];
		for(i = 0;i < index ;i++)
			z[i] = r[i];
		return z;

    }
}