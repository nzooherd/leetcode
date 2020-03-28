/**
 * Return an array of arrays of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int C(int numsSize)
{
	int r=1;
	while(numsSize){
		r*=(numsSize--);
	}
	return r;
}
void swap(int *a,int *b)
{
	int temp=*a;
	*a=*b;
	*b=temp;
}
int* next(int*nums,int numsSize)
{
	int *r,i,min=100000,flag=0,flag_=0;
	r=(int*)malloc(sizeof(int)*numsSize);
	for(i=0;i<numsSize;i++)
		r[i]=nums[i];
	for(i=numsSize-1;i>=1;i--)
		if(r[i]>r[i-1]) break;
	flag=i-1;
	for(i=numsSize-1;i>flag;i--){
		if(r[i]>r[flag]&&min>r[i]){
			flag_=i;
			min=r[i];
		}
	}
	swap(&r[flag],&r[flag_]);
	for(i=flag+1;i<(flag+numsSize+1)/2;i++)
		swap(&r[i],&r[numsSize+flag-i]);
	return r;	
}
void paixu(int *nums,int numsSize)
{
	int i,j,temp=0;
	for(i=1;i<numsSize;i++){
		temp=nums[i];
		for(j=i-1;temp<nums[j]&&j>=0;j--){
			nums[j+1]=nums[j];
		}
		nums[j+1]=temp;
	}
}
int** permute(int* nums, int numsSize, int* returnSize) {
   int **r,num,i;
	num=C(numsSize);
	*returnSize=num;
	r=(int **)malloc(sizeof(int*)*num);
	for(i=0;i<num;i++)
		*(r+i)=(int *)malloc(sizeof(int)*numsSize);
	paixu(nums,numsSize);
	for(i=0;i<numsSize;i++)
		r[0][i]=nums[i];
	for(i=1;i<num-1;i++){
		r[i]=next(r[i-1],numsSize);
	}
	for(i=0;i<numsSize;i++)
		r[num-1][i]=nums[numsSize-1-i];
	return r;
    
}