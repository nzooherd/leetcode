public class Solution {
	public int maxProfit(int[] prices) {
		int ans = 0;
		int buy;
		for(int i = 1; i < prices.length; i++) {
			while(i < prices.length && prices[i] < prices[i-1]) i++;
			buy = prices[i-1];
			while(i < prices.length && prices[i] > prices[i-1]) i++;
			ans += prices[i-1] - buy;	
		}
		return ans;
	}
}