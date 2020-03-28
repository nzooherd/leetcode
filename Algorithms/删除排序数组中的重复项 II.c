int removeDuplicates(int* nums, int numsSize) {
	int i=0,k=0,j=0,map[10000];
	memset(map,0,sizeof(map));
	if(numsSize>2){
		map[0]=nums[0];
		map[1]=nums[1];
		j=2;
		for(i=2;i<numsSize;i++){
			if(nums[i]==nums[i-1]&&nums[i-1]==nums[i-2]) k++;
			else{
				map[j++]=nums[i];
			}
		}
	}
	else k=0;
	for(i=0;i<j;i++)
		nums[i]=map[i];
	return  numsSize-k;
    
}