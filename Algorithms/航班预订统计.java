class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
    	int[] res = new int[n];
    	HashMap<Integer, ArrayList<Integer>>  index2nums = new HashMap<>();
    	for(int i = 0; i < bookings.length; i++){
    		int[] booking = bookings[i];
    		if(!index2nums.containsKey(booking[0])){
    			index2nums.put(booking[0], new ArrayList<Integer>());
    		}
    		if(!index2nums.containsKey(booking[1])){
    			index2nums.put(booking[1], new ArrayList<Integer>());
    		}
    		index2nums.get(booking[0]).add(booking[2]);
    		index2nums.get(booking[1]).add(-booking[2]);
    	}

    	int curTicketNum = 0;
    	for(int i = 0; i < n; i++){
    		int curIndex = i + 1;
    		int reduceNum = 0;
    		for(int num : index2nums.getOrDefault(curIndex, new ArrayList<>())){
    			if(num > 0){
    				curTicketNum += num;
    			}else{
    				reduceNum += -num;
    			}
    		}
    		res[i] = curTicketNum;
    		curTicketNum -= reduceNum;
    	}
    	return res;


    }
}