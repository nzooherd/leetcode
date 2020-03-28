/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* searchRange(int* nums, int numsSize, int target, int* returnSize) {
 	int *r;
	int left,right,med,i,j;
	r=(int *)malloc(sizeof(int)*2);
	left=0;right=numsSize-1;
	while(left<=right){
		med=(left+right)/2;
		if(nums[med]<target) left=med+1;
		else if(nums[med]>target) right=med-1;
		else break;
	}
	if(left>right) {
		r[0]=-1;r[1]=-1;
	}
	else{
		for(i=0;nums[med-i]==target&&(med-i)>=0;i++) ;
		for(j=0;nums[med+j]==target&&j<numsSize;j++);
		r[0]=med-i+1;r[1]=med+j-1;
	}
	*returnSize=2;
	return r;

}