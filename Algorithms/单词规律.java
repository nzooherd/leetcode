class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] inputs = str.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> rmap = new HashMap<>();
        char[] cs = pattern.toCharArray();
        if(inputs.length != pattern.length()) {
            return false;
        }
        for(int i = 0; i < cs.length; i++){
            if(map.containsKey(cs[i])){
                if(!map.get(cs[i]).equals(inputs[i])){
                    return false;
                }
            } else {
                map.put(cs[i], inputs[i]);
                if(rmap.containsKey(inputs[i])) {
                    return false;
                }
                rmap.put(inputs[i], cs[i]);
            }
        }
        return true;
    }
}