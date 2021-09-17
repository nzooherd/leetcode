class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
    	if(s == null || s.length() <= 2){
    		return s.length();
    	}

    	HashMap<Character, Integer> hashMap = new HashMap<>();
    	int start = 0, end = 1, result = 0;
    	hashMap.put(s.charAt(start), 1);
    	while(end < s.length()){
    		int count = hashMap.getOrDefault(s.charAt(end), 0);
    		hashMap.put(s.charAt(end), count + 1);
    		while(hashMap.size() > 2){
    			count = hashMap.get(s.charAt(start));
    			count -= 1;
                hashMap.put(s.charAt(start), count);
    			if(count == 0){
    				hashMap.remove(s.charAt(start));
    			}
    			start += 1;
    		}
    		result = Math.max(result, end - start + 1);
    		end++;
    	}
    	return result;

    }
}