int removeDuplicates(int* nums, int numsSize) {
  
	int i,r=0;
	short temp_[100000];
	short temp[100000];
	int  tp[1000];
	memset(temp,0,sizeof(temp));
	memset(temp_,0,sizeof(temp_));
	for(i=0;i<numsSize;i++){
		if(nums[i]>=0){
			if(temp[nums[i]]) ;
			else{
				tp[r++]=nums[i];
				temp[nums[i]]=1;
			}
		}
		else{
			if(temp_[(-1)*nums[i]]) ;
			else{
				tp[r++]=nums[i];
				temp_[(-1)*nums[i]]=1;
			}
		}
	}
	for(i=0;i<r;i++)
		nums[i]=tp[i];
	return r;
}