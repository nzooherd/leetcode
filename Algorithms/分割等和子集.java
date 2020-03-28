public class Solution {
    public boolean canPartition(int[] nums) {
		int sum = 0;
		if(nums == null) return true;
		for(int i : nums)
			sum += i;
		if(sum % 2 != 0) return false;
		boolean[] dp = new boolean[sum/2+1];
		dp[0] = true;
		for(int i = 1; i < nums.length; i++) {
			for(int j = sum/2; j >= nums[i-1]; j--)
				dp[j] = dp[j] || dp[j-nums[i-1]];
		}
		return dp[sum/2];

    }
}