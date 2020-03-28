int firstMissingPositive(int* nums, int numsSize) {
    int i;
	short map[1000000];
	memset(map,0,sizeof(map));
	for(i=0;i<numsSize;i++){
		if(nums[i]>0){
			map[nums[i]]=1;
		}
	}
	i=1;
	while(map[i])
		i++;
	return i;
}