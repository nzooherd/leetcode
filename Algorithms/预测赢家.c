#define max(a,b) (a)>(b)?(a):(b)
bool PredictTheWinner(int* nums, int numsSize) {
	int i,j,k,sum;
	bool flag = false;
	if(numsSize==1) return true;
	int** dp=(int**)malloc(sizeof(int*)*numsSize);
	for(i = 0;i < numsSize;i++){
		*(dp+i)=(int*)malloc(sizeof(int)*numsSize);
	}
	for(i = 0;i < numsSize;i++)
		for(j = 0;j < numsSize;j++){
			if(i == j) dp[i][j] = nums[i];
			else dp[i][j] = 0;
		}
	for(i = 1;i < numsSize;i++){
		for(j = 0;j+i < numsSize;j++){
			sum = 0;
			for(k = j;k <= j+i;k++){
				sum += nums[k];
			}
			dp[j][j+i]=max(sum-dp[j][j+i-1],sum-dp[j+1][j+i]);
		}
	}
	if(dp[0][numsSize-1]*2 >= sum) flag = true;
	else ;
	return flag;
}