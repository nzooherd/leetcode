public class Solution {
	public int distributeCandies(int[] candies) {
		if(candies.length == 0) return 0;
		int kinds = 0;
		Arrays.sort(candies);
		for(int i = 0; i < candies.length; i++) {
			if(i == 0) {
				kinds++;
			}
			else if(candies[i] != candies[i-1]) kinds++;
		}
		return Math.min(kinds, candies.length/2);

	}
}