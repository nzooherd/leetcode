class Solution {
    public int minEatingSpeed(int[] piles, int H) {
    	int maxCount = 0;
    	long sumCount = 0;
    	for(int pile : piles){
    		maxCount = Math.max(maxCount, pile);
    		sumCount += pile;
    	}

    	if(H == piles.length){
    		return maxCount;
    	}
    	if(H >= sumCount){
    		return 1;
    	}

    	int left = 1, right = maxCount;

    	while(left < right){
    		int mid = (left + right) / 2;
    		int count = 0;
    		for(int pile : piles){
    			count += (pile / mid + (pile % mid == 0 ? 0 : 1));
    		}
    		if(count <= H){
    			right = mid - 1;
    		} else{
    			left = mid + 1;
    		}
    	}
    	int count = 0, mid = left;
    	for(int pile : piles){
    		count += (pile / mid + (pile % mid == 0 ? 0 : 1));
    	}
    	if(count <= H){
    		return mid;
    	} else{
    		return mid + 1;
    	}
    }
}