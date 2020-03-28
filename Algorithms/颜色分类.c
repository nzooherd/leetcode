void sortColors(int* nums, int numsSize) {
    int map[3],i,j,k=0;
	memset(map,0,sizeof(map));
	for(i=0;i<numsSize;i++){
		if(nums[i]==0) map[0]++;
		else if(nums[i]==1) map[1]++;
		else map[2]++;
	}
	for(i=0;i<3;i++){
		for(j=0;j<map[i];j++){
			nums[k]=i;
			k++;
		}
	}
    
}