public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
		int sum = 0;
		int flag = 0;
		for(int i = 0; i < gas.length; i++){
			sum += gas[i] - cost[i];
		}
		if(sum < 0) return -1;
		for(int i = 0; i < gas.length; i++){
			sum += gas[i] - cost[i];
			if(sum < 0){
				flag = i+1;
				sum = 0;
			}	
		}
		return flag;
    }
}