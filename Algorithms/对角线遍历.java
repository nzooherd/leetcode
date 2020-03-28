public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
		int[] ans = new int[matrix.length*matrix[0].length];
		int[] flag = new int[matrix.length];
		for(int i = 0; i < flag.length; i++)
			flag[i] = -1;
		flag[0] = 0;
		ans[0] = matrix[0][0];
		int index = 1;
		while(index != ans.length){
			int i = 0;
			for(i = 0; i < flag.length && flag[i] != -1; i++) {
				if(flag[i]+1 < matrix[i].length) ans[index++] = matrix[i][++flag[i]];
			}
			if(i < flag.length && flag[i]+1 < matrix[i].length) ans[index++] = matrix[i][++flag[i]];
			for(i = (i+1 < flag.length ? i+1 : flag.length-1) ; i >= 0; i--) {
				if(flag[i]+1 < matrix[i].length) ans[index++] = matrix[i][++flag[i]];	
				else break;
			}
		}
		return ans;   
    }
}