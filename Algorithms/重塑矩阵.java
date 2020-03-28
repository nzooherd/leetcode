public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
		if(nums == null) return nums;
		if(r*c != nums.length*nums[0].length) return nums;
		int r_ = nums.length, c_ = nums[0].length;
		int row = 0, col = 0;
		int[][] ans = new int[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				ans[i][j] = nums[row][col++];
				if(col == c_){
					row++;
					col = 0;
				}

			}
		}
		return ans;
    }
}