/**
 * Return an array of arrays.
 * Note: The returned array must be malloced, assume caller calls free().
 */
 int judge(int **map,int x,int y,int n)
{
	if(x>=0&&x<n&&y>=0&&y<n)
		return (!map[x][y]);
	else return 0;
}
int *search(int **map,int x,int y,int n)
{
	int dir[4][2]={0,1,0,-1,1,0,-1,0};
	int *flag,i;
	flag=(int *)malloc(sizeof(int)*2);
	flag[0]=-1;flag[1]=-1;
	for(i=0;i<4;i++){
		if(judge(map,x+dir[i][0],y+dir[i][1],n)){
			flag[0]=dir[i][0];
			flag[1]=dir[i][1];
			return flag;
		}
	}
	return flag;
}
int** generateMatrix(int n) {
    int **r,**map,*flag;
	int i,j,x,y,num=1;
	map=(int**)malloc(sizeof(int*)*n);
	r=(int**)malloc(sizeof(int *)*n);
	for(i=0;i<n;i++){
		*(r+i)=(int*)malloc(sizeof(int)*n);
		*(map+i)=(int*)malloc(sizeof(int)*n);
	}
	flag=(int*)malloc(sizeof(int)*2);
	for(i=0;i<n;i++)
		for(j=0;j<n;j++){
			map[i][j]=0;
		}
	x=0;y=0;
	if(n) r[0][0]=1;
	flag=search(map,x,y,n);
	while(flag[0]!=-1||flag[1]!=-1){
		while(judge(map,x,y,n)){
			r[x][y]=num;
			num++;
			map[x][y]=1;
			x+=flag[0];
			y+=flag[1];
		}
		x-=flag[0];
		y-=flag[1];
		map[x][y]=0;
		flag=search(map,x,y,n);
		num--;	
	}
	return r;
}