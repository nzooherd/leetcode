int singleNumber(int* nums, int numsSize) {	
	int i,max=0,min=0;
	for(i=0;i<numsSize;i++){
		if(nums[i]>max) max=nums[i];
		if(nums[i]<min) min=nums[i];
	}
	short *map,*map_;
	map=(short*)malloc(sizeof(int)*(max+1));
	map_=(short*)malloc(sizeof(int)*((min-1)*(-1)));
	for(i=0;i<max;i++)
		map[i]=0;
	for(i=0;i<(-1)*(min-1);i++)
		map_[i]=0;
	for(i=0;i<numsSize;i++){
		if(nums[i]>=0) map[nums[i]]++;
		if(min<0&&nums[i]<0)  map_[(-1)*nums[i]]++;
	}
	for(i=0;i<(max+1);i++)
		if(map[i]==1){
			goto k;
		}
	if(min<0){
		for(i=0;i<(-1)*(min-1);i++)
			if(map_[i]==1){
				i=(i)*(-1);
				break;
			}
	}
	k: return i;

}