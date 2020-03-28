#define max 10000
int minPathSum(int** grid, int gridRowSize, int gridColSize) {
	int i,j;
	int **map;
	map=(int**)malloc(sizeof(int*)*gridRowSize);
	for(i=0;i<gridRowSize;i++) {
		*(map+i)=(int)malloc(sizeof(int)*gridColSize);
	}
	for(i=0;i<gridRowSize;i++)
		for(j=0;j<gridColSize;j++)
			map[i][j]=0;
	map[0][0]=grid[0][0];
	for(j=1;j<gridColSize;j++)
		map[0][j]=grid[0][j]+map[0][j-1];
	for(i=1;i<gridRowSize;i++)
		map[i][0]=grid[i][0]+map[i-1][0];
	for(i=1;i<gridRowSize;i++){
		for(j=1;j<gridColSize;j++){
			map[i][j]=(map[i][j-1]<map[i-1][j]?map[i][j-1]:map[i-1][j])+grid[i][j];
		}
	}
	return map[gridRowSize-1][gridColSize-1];
}