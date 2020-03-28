public class Solution {
    public void rotate(int[] nums, int k) {
		k %= nums.length;
		reversal(nums,0,nums.length-k-1);
		reversal(nums,nums.length-k,nums.length-1);
		reversal(nums,0,nums.length-1);
        
    }
	private static void reversal(int[] nums,int s,int e){
		int i = 0,temp = 0;
		for(i = s;i <= (s+e)/2;i++){
			temp = nums[i];
			nums[i] = nums[e-i+s];
			nums[e-i+s] = temp;
		}
	}
}