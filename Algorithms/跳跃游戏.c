bool canJump(int* nums, int numsSize) {
	int i=0,j,k=0,flag,max=0,temp,temp_i,count=0;
	while(i!=k||count==0){
		count=1;
		temp_i=i;max=0;
		for(i=i+1;i<numsSize&&i<=nums[temp_i]+temp_i;i++){
			temp=nums[i]+i;
			if(temp>=max){
				max=temp;
				flag=i;
			}
		}
		k=temp_i;
		i=flag;
		printf("i=%d k=%d\n",i,k );
		if(max>=numsSize-1) return 1;
	}
	return 0;
}