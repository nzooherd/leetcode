int longestConsecutive(int* nums, int numsSize) {
	int i=0,j=0,temp,r=0,max=0;
	for(i=1;i<numsSize;i++){
		temp=nums[i];
		for(j=i-1;nums[j]>temp&&j>=0;j--){
			nums[j+1]=nums[j];
		}
		nums[j+1]=temp;
	}
	if(numsSize) max=1;
	r=1;
	for(i=1;i<numsSize;i++){
		if(nums[i]==nums[i-1]+1){
			r++;
			if(r>max) max=r;
		}
		else if(nums[i]==nums[i-1]) ;
		else r=1;
	}
	return max;
    
}