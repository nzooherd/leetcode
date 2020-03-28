/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
 int judge(int **map,int x,int y,int matrixRowSize,int matrixColSize)
{
	if(x>=0&&x<matrixRowSize&&y>=0&&y<matrixColSize)
		return (!map[x][y]);
	else return 0;
}
int *search(int **map,int x,int y,int matrixRowSize,int matrixColSize)
{
	int dir[4][2]={0,1,0,-1,1,0,-1,0};
	int *flag,i;
	flag=(int *)malloc(sizeof(int)*2);
	flag[0]=-1;flag[1]=-1;
	for(i=0;i<4;i++){
		if(judge(map,x+dir[i][0],y+dir[i][1],matrixRowSize,matrixColSize)){
			flag[0]=dir[i][0];
			flag[1]=dir[i][1];
			return flag;
		}
	}
	return flag;
}
int* spiralOrder(int** matrix, int matrixRowSize, int matrixColSize) {
  int **map,*r,*flag,num=0;
	int i,j,x,y;
	map=(int **)malloc(sizeof(int *)*matrixRowSize);
	for(i=0;i<matrixRowSize;i++)
		*(map+i)=(int*)malloc(sizeof(int)*matrixColSize);
	r=(int*)malloc(sizeof(int)*(matrixColSize*matrixRowSize));
	flag=(int*)malloc(sizeof(int)*2);
	for(i=0;i<matrixRowSize;i++)
		for(j=0;j<matrixColSize;j++)
			map[i][j]=0;
	x=0;y=0;num=0;
	if(matrixColSize&&matrixRowSize){
		r[0]=matrix[0][0];
	}
	flag=search(map,0,0,matrixRowSize,matrixColSize);
    while(flag[0]!=-1||flag[1]!=-1){
		while(judge(map,x,y,matrixRowSize,matrixColSize)){
			r[num]=matrix[x][y];
			num++;
			map[x][y]=1;
			x+=flag[0];
			y+=flag[1];
			}
		x-=flag[0];
		y-=flag[1];
		map[x][y]=0;
		flag=search(map,x,y,matrixRowSize,matrixColSize);
		num--;	
	}
	return r;
}