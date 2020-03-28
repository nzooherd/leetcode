/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* maxSlidingWindow(int* nums, int numsSize, int k, int* returnSize) {
    	if(numsSize == 0) return NULL;
	int* ans = (int*)malloc(sizeof(int) * (numsSize-k+1));
	*returnSize = (numsSize-k+1);
	int max = nums[0], index = 0;
	for(int i = 0; i < k; i++)  {
		if(nums[i] > max) max = nums[i];
	}
	ans[index++] = max;
	for(int i = k; i < numsSize; i++) {
		if(ans[i-k] == max) {
			max = nums[i-k+1];
			for(int j = i-k+1; j <= i; j++){
				if(nums[j] > max) max = nums[j];
			}
			ans[index++] = max;
		}
		else {
			max = nums[i] > max ? nums[i] : max;
			ans[index++] = max;
		}

	}
	return ans;
}