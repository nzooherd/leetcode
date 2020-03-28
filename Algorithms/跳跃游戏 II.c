int jump(int* nums, int numsSize) {
	int i=0,j=0,k=0,max=0,size=0,flag=0;
	if(numsSize==1) return 0; 
	while(i<numsSize){
		size=nums[i];
		if(i+size>=numsSize-1) break;
		max=0;
		for(j=1;j<=size;j++){
			if(nums[i+j]+(i+j)>max){
				max=(nums[i+j]+(i+j));
				flag=j;
			}
		}
		i+=flag;
		printf("i=%d\n",i );
		k++;
	}
	return k+1;

    
}