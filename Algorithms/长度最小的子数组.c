int minSubArrayLen(int s, int* nums, int numsSize) {
	int i = 0, j = 0;
	int min = 10000, sum = 0;
	for(; j < numsSize; j++) {
		sum += nums[j];
		if(sum >= s) {
			if(min > j-i+1) min = j-i+1;
			sum -= nums[i];	
			i++;
			while(sum >= s) {
				if(min > j-i+1) min = j-i+1;
				sum -= nums[i];
				i++;	
			}
		}
	}
	if(min == 10000) return 0;
	return min;
}