int singleNumber(int* nums, int numsSize) {
	int i=0,j=0,temp=0;
	for(i=1;i<numsSize;i++){
		temp=nums[i];
		for(j=i-1;nums[j]>temp&&j>=0;j--){
			nums[j+1]=nums[j];
		}
		nums[j+1]=temp;
	}
	for(i=0;i<numsSize-1;i++){
		if(nums[i+1]!=nums[i]&&!i||nums[i]!=nums[i+1]&&nums[i-1]!=nums[i]) break;
	}
	return nums[i];
}