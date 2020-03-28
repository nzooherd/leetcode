int searchInsert(int* nums, int numsSize, int target) {
   int i;
	for(i=0;i<=numsSize-1;i++){
		if(nums[i]>=target) break;
	}
	return i;
    
}