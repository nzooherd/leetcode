class Solution {
    public int numSub(String s) {
    	long res = 0;
    	int left = 0, right = 0;
    	int lenS = s.length();

    	while(left < lenS){
    		while(left < lenS && s.charAt(left) != '1'){
    			left++;
    		}
    		right = left;
    		while(right < lenS && s.charAt(right) == '1'){
    			right++;
    		}

    		long count = right - left;
    		res += (count + 1) * (count) / 2;
    		res %= 1000000007;

    		left = right;
    	}

    	return (int)res;

    }
}