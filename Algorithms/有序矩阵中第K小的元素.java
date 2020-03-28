public class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		if(k == 1) return matrix[0][0];
		if(k == matrix.length*matrix.length) return matrix[matrix.length-1][matrix[0].length-1];
		int[] vis = new int[matrix.length];
		for(int i = 0; i < vis.length; i++)
			vis[i] = -1;
		vis[0] = 0;
		int min = 2147483647, flag = 0, count = 1;
		while(count != k) {
			min = 2147283647;
			for(int i = 0; (i == 0 || vis[i-1] != -1 && i < vis.length); i++) {
				if(vis[i] == matrix[i].length-1) continue;
				if(matrix[i][vis[i]+1] < min) {
					min = matrix[i][vis[i]+1];
					flag = i;
				}
			}
			count++;
			vis[flag]++;
			if(count == k) return min;
		}
		return min;
	}
}