public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0) return false;
		int raw = 0, rawsum = matrix.length;
		int col = matrix[0].length-1, colsum = col;
		while(col >= 0 && raw < rawsum) {
			int temp = matrix[raw][col];
			if(temp < target) raw++;
			else if(temp == target) return true;
			else col--;
		}
		return false;
	}
}