int maxSubArray(int* nums, int numsSize) {
 int max=nums[0],k=0,i;
	for(i=0;i<numsSize;i++){
		k+=nums[i];
		if(k>max) max=k;
		if(k<0) k=0;
	}
	return max;
}