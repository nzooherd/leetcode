class Solution {
    public int numIdenticalPairs(int[] nums) {
    	HashMap<Integer, Integer> num2count = new HashMap<>();
    	for(int num : nums){
    		if(!num2count.containsKey(num)){
    			num2count.put(num, 0);
    		}
    		num2count.put(num, num2count.get(num) + 1);
    	}

    	int res = 0;
    	for(Map.Entry<Integer, Integer> entry : num2count.entrySet()){
    		int count = entry.getValue();
    		res += count * (count - 1) / 2;
    	}
    	return res;
    }
}