void paixu(int *nums,int s,int e)
{
	int i,j,temp;
	for(i=s+1;i<=e;i++){
		temp=nums[i];
		for(j=i-1;temp<nums[j]&&j>=s;j--){
			nums[j+1]=nums[j];
		}
		nums[j+1]=temp;
	}
}
void swap(int*a,int*b)
{
	int temp=*a;
	*a=*b;
	*b=temp;
}
void nextPermutation(int* nums,int numsSize)
{
	int i,j,r,min=10000,flag=0;
	if(numsSize>1){
		for(i=numsSize-1;i>=1;i--){
			if(nums[i]>nums[i-1]) {
				flag=1;
				break;
			}
		}
		if(flag){
			j=i-1;
			r=i;
			for(i=i;i<=numsSize-1;i++){
				if(nums[i]>nums[j]&&min>nums[i]){
					min=nums[i];
					r=i;
				}
			}
			swap(&nums[r],&nums[j]);
			paixu(nums,j+1,numsSize-1);	
		}
		else{
			for(i=0;i<numsSize/2;i++){
				swap(&nums[i],&nums[numsSize-i-1]);
			}
		}
	}
}