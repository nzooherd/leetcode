int uniquePaths(int m, int n) {
int **map;
	int x,y,i,j,temp_x,temp_y;
	map=(int **)malloc(sizeof(int*)*m);
	for(i=0;i<m;i++)
		*(map+i)=(int*)malloc(sizeof(int)*n);
	for(i=0;i<m;i++){
		for(j=0;j<n;j++)
			map[i][j]=0;
	}
	for(i=0;i<m;i++)
		map[i][0]=1;
	for(j=0;j<n;j++)
		map[0][j]=1;
	for(i=1;i<(m<n?m:n);i++){
		x=i;y=i;temp_y=0;temp_x=0;
		while(y+temp_y<n){
			map[x][y+temp_y]=(map[x-1][y+temp_y])+(map[x][y+temp_y-1]);
			temp_y++;
		}
		while(x+temp_x<m){
			map[x+temp_x][y]=(map[x+temp_x][y-1])+(map[x+temp_x-1][y]);
			temp_x++;
		}
	}
	return map[m-1][n-1];
}