void insertSort(int *nums,int numsSize)
{
	int i=0,j=0,temp=0;
	for(i=1;i<numsSize;i++){
		temp=nums[i];
		for(j=i;temp>nums[j-1]&&j>=1;j--){
			nums[j]=nums[j-1];
		}
		nums[j]=temp;
	}
}
int findMid(int *nums,int numsSize)
{
	if(numsSize<=5){
		insertSort(nums,numsSize);
		return nums[numsSize/2];
	}
	int a[numsSize/5],temp[5],i=0,j=0;
	for(i=0;i<numsSize/5;i++){
		for(j=0;j<5;j++)
			temp[j]=nums[i*5+j];
		insertSort(temp,5);
		a[i]=temp[2];
	}
	return findMid(a,numsSize/5);
}
int findKthLargest(int* nums, int numsSize, int k) {
	int hingle=0,i=0,j=0,*temp,r=0,end=0,start;
	if(numsSize<=5){
		insertSort(nums,numsSize);
		for(i=0;i<numsSize;i++)
			printf("%d\n",nums[i] );
		return nums[k-1];
	}
	hingle=findMid(nums,numsSize);
	printf("hingle=%d\n",hingle);
	temp=(int*)malloc(sizeof(int)*numsSize);
	start=0;end=numsSize-1;
	for(i=0;i<numsSize;i++){
		if(nums[i]<hingle){
			temp[end--]=nums[i];
		}
		if(nums[i]>hingle)
			temp[start++]=nums[i];
	}
	if(k-1>=start||k-1<=end-1) r=hingle;
	if(k-1>end){
		printf("start=%d\n",start );
		r=findKthLargest(temp+end+1,numsSize-end-1,k-end-1);
	}
	if(k-1<start){
		printf("end=%d\n",end);
		r=findKthLargest(temp,start,k);
	}
	return r;
	return r;
}