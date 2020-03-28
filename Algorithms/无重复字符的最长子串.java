class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if(s == null || s.length() <= 1) return s == null ? 0 : s.length();
        int pre = 1;
        char[] cs = s.toCharArray();
        map.put(cs[0], 0);
        int ret = 1;
        for(int i = 1; i < cs.length; i++){
            if(!map.containsKey(cs[i]) || map.get(cs[i]) < (i - pre - 1)){
                pre = pre + 1;
                ret = Math.max(pre, ret);
            } else{
                pre = i - map.get(cs[i]);
                ret = Math.max(pre, ret);
            }
            map.put(cs[i], i);
        }
        return ret;
        
    }
}