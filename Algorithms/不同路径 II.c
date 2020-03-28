int uniquePathsWithObstacles(int** obstacleGrid, int obstacleGridRowSize, int obstacleGridColSize) {
  int **map;
	int x,y,i,j,temp_x,temp_y,m,n;
	m=obstacleGridRowSize;n=obstacleGridColSize;
	map=(int **)malloc(sizeof(int*)*m);
	for(i=0;i<m;i++)
		*(map+i)=(int*)malloc(sizeof(int)*n);
	for(i=0;i<m;i++){
		for(j=0;j<n;j++)
			map[i][j]=0;
	}
	if(!obstacleGrid[0][0]) map[0][0]=1;
	for(i=1;i<m;i++)
		if(!obstacleGrid[i][0]) map[i][0]=map[i-1][0];
	for(j=1;j<n;j++)
		if(!obstacleGrid[0][j]) map[0][j]=map[0][j-1];
	for(i=1;i<(m<n?m:n);i++){
		x=i;y=i;temp_y=0;temp_x=0;
		while(y+temp_y<n){
			if(!obstacleGrid[x][y+temp_y]){
				map[x][y+temp_y]=(map[x-1][y+temp_y])+(map[x][y+temp_y-1]);
				temp_y++;
			}
			else {
				map[x][y+temp_y]=0;
				temp_y++;
			}
		}
		while(x+temp_x<m){
			if(!obstacleGrid[x+temp_x][y]){
				map[x+temp_x][y]=(map[x+temp_x][y-1])+(map[x+temp_x-1][y]);
				temp_x++;
			}
			else {
				map[x+temp_x][y]=0;
				temp_x++;
			}
		}
	}
	return map[m-1][n-1];
 
}