/**
 * Return an array of arrays of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
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
	map[x][y]=2;
}
void dfs(char ***Map,int **map,int k,int n,int *r)
{
	int i,j,h;
	int map_[10][10];
	if(k==n){
		*r+=1;
		for(i=0;i<n;i++){
		 	for(j=0;j<n;j++){
		 		if(map[i][j]==2){ 
		 			Map[(*r)-1][i][j]='Q';
		 		}
		 		else 
		 			Map[(*r)-1][i][j]='.';
		 	}
		 	Map[(*r)-1][i][j]='\0';
		 }
	}
	else{
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				map_[i][j]=map[i][j];
		for(i=0;i<n;i++){
			if(!map[k][i]){
				view(map,k,i,n);
				dfs(Map,map,k+1,n,r);
			}
			for(j=0;j<n;j++)
				for(h=0;h<n;h++)
					map[j][h]=map_[j][h];
		}
	}
}
char*** solveNQueens(int n, int* returnSize) {
int i,j,r=0,k;
	int **map;
	char ***Map;
	map=(int**)malloc(sizeof(int *)*n);
	for(i=0;i<n;i++)
		*(map+i)=(int *)malloc(sizeof(int)*(n+1));
	Map=(char ***)malloc(sizeof(char **)*2000);
	for(i=0;i<2000;i++)
		*(Map+i)=(char**)malloc(sizeof(char*)*(n+1));
	for(i=0;i<2000;i++)
		for(j=0;j<n;j++)
			*(*(Map+i)+j)=(char *)malloc(sizeof(char)*(n+1));
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			map[i][j]=0;
	for(i=0;i<2000;i++)
		for(j=0;j<n;j++)
			for(k=0;k<n;k++)
				Map[i][j][k]='\0';
	dfs(Map,map,0,n,&r);
	*returnSize=r;
	return Map;
}