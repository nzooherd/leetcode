bool checkSubarraySum(int* nums, int numsSize, int k) {
	int sum = 0;
	for(int i = 0; i < numsSize-1; i++) {
		sum = nums[i];
		for(int j = i+1; j < numsSize; j++) {
			sum += nums[j];
			if(k == 0){
			    if(sum == 0) return 1;
			}
			else if(sum % k == 0) return 1;
		}
	}
	return 0;   
}