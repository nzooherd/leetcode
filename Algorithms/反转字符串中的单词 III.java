class Solution {
    public String reverseWords(String s) {
    	if(s == null){
    		return "";
    	}

    	StringBuilder res = new StringBuilder();
    	int start = 0, end = 0, len = s.length();
    	while(true){
    		while(start < len && s.charAt(start) == ' '){
    			res.append(' ');
    			start++;
    		}
    		if(start == len){
    			break;
    		}
    		end = start;
    		while(end < len && s.charAt(end) != ' '){
    			end += 1;
    		}
    		end--;
    		for(int i = end; i >= start; i--){
    			res.append(s.charAt(i));
    		}
    		start = end + 1;
    	}
    	return res.toString();

    }
}