class Solution {
    public String toLowerCase(String str) {
        if(str == null) return null;
        if(str.length() < 1) return new String();
        char[] cs = str.toCharArray();
        for(int i = 0; i < cs.length; i++){
            if(cs[i] >= 'A' && cs[i] <= 'Z') {
                cs[i] = (char)(cs[i] - ('A' - 'a'));
            }
        }
        return new String(cs);
    }
}