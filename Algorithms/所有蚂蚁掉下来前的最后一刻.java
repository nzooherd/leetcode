class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
    	int min = 10001, max = 0;
    	for(int num : left){
    		max = Math.max(num, max);
    	}
    	for(int num : right){
    		min = Math.min(num, min);
    	}
    	return Math.max(n - min, max);
    }
}