int dir[4][2]={1,1,1,-1,-1,1,-1,-1};
int judge(int x,int y,int n)
{
	if(x<n&&x>=0&&y<n&&y>=0)
		return 1;
	else return 0;
}
void view(int **map,int x,int y,int n)
{
	int i,temp_x,temp_y;
	for(i=0;i<n;i++)
		map[x][i]=1;
	for(i=0;i<n;i++)
		map[i][y]=1;
	for(i=0;i<4;i++){
		temp_x=dir[i][0],temp_y=dir[i][1];
		while(judge(x+temp_x,y+temp_y,n)){
			map[x+temp_x][y+temp_y]=1;
			temp_x+=dir[i][0];
			temp_y+=dir[i][1];
		}
	}
}
void dfs(int **map,int k,int n,int *r)
{
	int i,j,h;
	int map_[10][10];
	if(k==n){
		*r+=1;
	}
	else{
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				map_[i][j]=map[i][j];
		for(i=0;i<n;i++){
			if(!map[k][i]){
				view(map,k,i,n);
				dfs(map,k+1,n,r);
			}
			for(j=0;j<n;j++)
				for(h=0;h<n;h++)
					map[j][h]=map_[j][h];
		}
	}
}
int totalNQueens(int n) {
  int i,j,r=0;
	int **map;
	map=(int**)malloc(sizeof(int *)*n);
	for(i=0;i<n;i++)
		*(map+i)=(int *)malloc(sizeof(int)*n);
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			map[i][j]=0;
	dfs(map,0,n,&r);
	return r;
    
}