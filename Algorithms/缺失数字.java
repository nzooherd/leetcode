public class Solution {
    public int missingNumber(int[] nums) {
		int[] NumCount=new int[nums.length+1];
		int i=0;
		for(i = 0;i < nums.length;i++){
			NumCount[nums[i]]++;
		}
		for(i = 0;i <= nums.length; i++){
			if(NumCount[i] == 0) break;
		}
		return i;
    }
}