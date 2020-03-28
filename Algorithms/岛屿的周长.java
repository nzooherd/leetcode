public class Solution {
    public int islandPerimeter(int[][] grid) {
		int x=0,y=0,r=0;
		for(x=0;x<grid.length;x++){
			for(y=0;y<grid[x].length;y++)
				r+=judge(grid,x,y);
		}
		for(y=0;y<grid[x-1].length;y++)
			if(grid[x-1][y]>0) r++;
		return r; 
    }
	int judge(int[][] grid,int x,int y){
		int[][] dir={{0,-1},{-1,0}};
		int temp_x=0,temp_y=0,r=0,i=0;
		if(y < grid[x].length-1) {
			for(i=0;i<2;i++){
				temp_x = x+dir[i][0];
				temp_y = y+dir[i][1];
				if(bianjie(grid,temp_x,temp_y)+grid[x][y]==1) r++;
				else ;
			}
		}
		else {
			for(i=0;i<2;i++){
				temp_x = x+dir[i][0];
				temp_y = y+dir[i][1];
				if(bianjie(grid,temp_x,temp_y)+grid[x][y]==1) r++;
				else ;
			}
			temp_x = x;
			temp_y = y+1;
			if(bianjie(grid,temp_x,temp_y)+grid[x][y]==1) r++;
			else ;
		}
		return r;


	}
	int bianjie(int[][] grid,int x,int y){
		if(x>=0&&y>=0&&x<grid.length&&y<grid[0].length) return grid[x][y];
		else return 0;
	} 

}