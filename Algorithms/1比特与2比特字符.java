class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits == null) return false;
        for(int i = 0; i < bits.length;){
            if(i == bits.length - 1) return true;
            if(bits[i] == 1){
                i += 2;
            } else {
                i += 1;
            }
        }
        return false;
    }
}