class Solution {
    public int jump(int[] nums) {
        int jump = 0, cur = 0, next = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > cur){
                jump++;
                cur = next;    
            }
            next = Math.max(next, i + nums[i]);
            
        }
        return jump;
    }
}