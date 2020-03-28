public class Solution {
	public int search(int[] nums, int target) {
		if(nums.length == 0) return -1;
		if(nums[0] <= nums[nums.length-1]) return search(nums, 0, nums.length-1, target);
		int left = 0, right = nums.length-1;
		int mid = (right - left)/2 + left;
		while(left <= right) {
			mid = (right - left)/2 + left;
			if(nums[left] < nums[right]) return search(nums, left, right, target);
			if(nums[mid] >= nums[left]) {
				if(target >= nums[left] && target <= nums[mid]) return(search(nums, left, mid, target));
				else left = mid+1;
			}
			else {
				if(target >= nums[mid] && target <= nums[right]) return(search(nums, mid, right, target));
				else right = mid-1;
			}

		}
		return -1;
	}
	public int search(int nums[], int left, int right, int target) {
		int mid = (right - left)/2 + left;
		while(left <= right) {
			if(nums[mid] == target) return mid;
			else if(nums[mid] < target) left = mid+1;
			else right = mid-1;
			mid = (right - left)/2 + left;
		}
		return -1;
	}
}