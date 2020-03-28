int removeElement(int* nums, int numsSize, int val) {
   int i,j,k=0;
	for(i=0;i<numsSize;i++){
		if(nums[i]!=val)
			nums[k++]=nums[i];
	}
	j=k;
	for(;k<numsSize;k++)
		nums[k]=0;
	return j;
    
}