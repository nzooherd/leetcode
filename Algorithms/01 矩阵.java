public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
		int i,j,r,c;
		int[][] result=new int[matrix.length][matrix[0].length];
		Queue<int[]> q=new LinkedList<>();
		int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
		for(i=0;i<matrix.length;i++){
			for(j=0;j<matrix[0].length;j++){
				if(matrix[i][j] == 0) {
					result[i][j]=0;
					q.offer(new int[]{i,j});
				}	
				else result[i][j] = 10001;
			}
		}
		while(!q.isEmpty()){
			int[] cell = q.poll();
			for(i=0;i<4;i++){
				r = cell[0]+dir[i][0];
				c = cell[1]+dir[i][1];	
				if(judge(r,c,matrix)&&result[r][c]==10001) {
					result[r][c] = result[cell[0]][cell[1]]+1;
					q.offer(new int[]{r,c});
				}
			}
		}
		return result;
    }
	public boolean judge(int x,int y,int[][] matrix){
		boolean r = false;
		if(x>=0&&x<matrix.length&&y>=0&&y<matrix[0].length) r = true;
		else r = false;
		return r;
	}
}