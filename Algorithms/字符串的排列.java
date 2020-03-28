class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null) return true;
        if(s2 == null || s2.length() < s1.length()) return false;
        int[] nums = new int[26];
        for(char c : s1.toCharArray()){
            nums[c - 'a']++;
        }
        for(int i = 0; i + s1.length() <= s2.length(); i++){
            if(judgeArrange(nums, s2.substring(i, i + s1.length()))) return true;
        }
        return false;
    }
    public boolean judgeArrange(int[] nums, String s2){
        int[] numberS2 = new int[26];
        for(char c : s2.toCharArray()){
            numberS2[c - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(nums[i] != numberS2[i]) return false;
        }
        return true;
    }
}