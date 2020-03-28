bool increasingTriplet(int* nums, int numsSize) {
	if(numsSize < 3) return 0;
	int flag1 = nums[0], flag2 = 2147483647, flag3 = 2147483647;
	for(int i = 0; i < numsSize; i++) {
		if(nums[i] < flag1) flag1 = nums[i];
		if(nums[i] > flag1 && nums[i] < flag2) flag2 = nums[i];
		if(nums[i] > flag2 ) return 1;
	}
	return 0;  
}