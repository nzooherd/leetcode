class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
    	if(arr.length < k){
    		return 0;
    	}

    	int left = 0, right = k - 1;
    	int curSum = 0, result = 0;
    	for(int i = 0; i <= right; i++){
    		curSum += arr[i];
    	}
    	while(right < arr.length - 1){
    		if(curSum >= k * threshold) {
    			result += 1;
    		}
    		curSum -= arr[left++];
    		curSum += arr[++right];
    	}
            		if(curSum >= k * threshold) {
    			result += 1;
    		}
    	return result;
    }
}