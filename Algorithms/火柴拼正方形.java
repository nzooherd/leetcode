public class Solution {
	public boolean makesquare(int[] nums){
		int sum = 0;
		if(nums.length < 4) return false;
		for(int i = 0; i < nums.length; i++)
			sum += nums[i];
		if(sum % 4 != 0) return false;
		int index = (int)Math.pow(2,nums.length);
		int i = 0;
		while(i < index) {
			int tempsum = 0, tempindex = 0;
			int temp = i, count = 0;
			while(temp != 0) {
				if((temp & 1) == 1) {
				    tempsum += nums[tempindex];
				    count++;
				}
				if(tempsum > sum/2) break;
				temp >>= 1;
				tempindex++;
			}
			if(tempsum == sum / 2) {
				temp = i;
				int[] binnum1 = new int[count];
				int[] binnum2 = new int[nums.length - count];
				boolean[] vis = new boolean[nums.length];
				int j = 0, k = 0;
				while(temp != 0){
					if((temp & 1) == 1) {
					    binnum1[j++] = nums[k];
					    vis[k] = true;
					}
					temp >>= 1;
					k++;
				}
				k = 0;
				for(int z = 0; z < nums.length; z++)
					if(!vis[z]) binnum2[k++] = nums[z];
				if(judge(binnum1) && judge(binnum2)){
				    for(int z = 0; z < binnum2.length; z++)
				        System.out.print(binnum2[z]);
				    return true;
				} 
			}
			i++;
		}
		return false;

	}
	public boolean judge(int[] nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++)
			sum += nums[i];
		boolean[] dp = new boolean[sum/2+1];
		dp[0] = true;
		for(int i = 0; i < nums.length; i++){
		    if(nums[i] >= dp.length) return false;
		    dp[nums[i]] = false;
		}		
		for(int i = 0; i < nums.length; i++){
			for(int j = dp.length-1; j >= nums[i]; j--)
				dp[j] = dp[j] | dp[j-nums[i]];
		}
		return dp[sum/2];
	}
}