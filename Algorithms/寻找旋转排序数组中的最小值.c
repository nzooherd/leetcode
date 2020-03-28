int findMin(int* nums, int numsSize) {
    	int min=INT_MAX,i;
	for(i=0;i<numsSize;i++)
		if(nums[i]<min){
			min=nums[i];
		}
	return min;
    
}