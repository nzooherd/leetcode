class Solution {
    public int countArrangement(int N) {
    	int[] dp = new int[1 << N];
    	for(int i = 0; i < N; i++){
    		dp[1 << (i)] = 1;
    	}

    	for(int i = 1; i < (1 << N); i++){
    		int currentCount = countOne(i) + 1;
    		for(int j = 0; j < N; j++){
    			if((j + 1) % currentCount != 0 && currentCount % (j + 1) != 0){
    				continue;
    			}
    			if ((i & (1 << j)) > 0) {
    				continue;
    			}
    			dp[(1 << j) | i] += dp[i];
    		}
    	}

    	return dp[(1 << N) - 1];

    }

    public int countOne(int N){
    	int count = 0;
    	while(N > 0){
    		N &= (N - 1);
    		count++;
    	}
    	return count;
    }
}