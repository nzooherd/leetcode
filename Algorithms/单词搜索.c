int judge(int **map,int row,int col,int x,int y)
{
	if(x>=0&&x<row&&y>=0&&y<col&&!map[x][y]) return 1;
	else return 0;

}
void dfs(char** board,int **map,int row,int col,int x,int y,char *word,int k,int *r,int l)
{	if(k==l) {
		*r=1;
	}
	else {
		int dir[4][2]={1,0,-1,0,0,1,0,-1};
		int temp_x=0,temp_y=0,i=0,temp=0;
		for(i=0;i<4;i++){
			temp_x=x+dir[i][0];temp_y=y+dir[i][1];
			temp=i;
			if(judge(map,row,col,temp_x,temp_y)&&board[temp_x][temp_y]==word[k]){
				map[temp_x][temp_y]=1;	
				dfs(board,map,row,col,temp_x,temp_y,word,k+1,r,l);
				if(*r) break; 
				map[temp_x][temp_y]=0;
			}
			i=temp;
		}
	}
}
bool exist(char** board, int boardRowSize, int boardColSize, char* word) {
    	int row=boardRowSize,col=boardColSize;
	int **map,i,j,l=0,r=0,x=0,y=0;
	map=(int**)malloc(sizeof(int*)*boardRowSize);
	for(i=0;i<boardRowSize;i++)
		*(map+i)=(int)malloc(sizeof(int)*boardColSize);
	for(i=0;i<row;i++)
		for(j=0;j<col;j++)
			map[i][j]=0;
	while(word[l]) l++;	
	if(!word[0]) return 1; 
	for(i=0;i<row;i++)
		for(j=0;j<col;j++)
			if(board[i][j]==word[0]){
				x=i;y=j;map[i][j]=1;
				dfs(board,map,row,col,x,y,word,1,&r,l);
				if(r) break;
				map[i][j]=0;
			}
	return r;
    
}