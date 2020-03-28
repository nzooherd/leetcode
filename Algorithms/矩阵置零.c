void setZeroes(int** matrix, int matrixRowSize, int matrixColSize) {
	int m,n,i,j;
	int **map;
	m=matrixRowSize;n=matrixColSize;
	map=(int**)malloc(sizeof(int*)*2);
	*(map+0)=(int*)malloc(sizeof(int)*m);
	*(map+1)=(int*)malloc(sizeof(int)*n);
	for(i=0;i<m;i++) map[0][i]=0;
	for(i=0;i<n;i++) map[1][i]=0;
	for(i=0;i<m;i++){
		for(j=0;j<n;j++){
			if(!matrix[i][j]){
				map[0][i]=1;
				map[1][j]=1;
			}
		}
	}
	for(i=0;i<m;i++){
		if(map[0][i]){
			printf("i=%d\n",i);
			for(j=0;j<n;j++)
				matrix[i][j]=0;
		}
	}
	for(j=0;j<n;j++){
		if(map[1][j]){
			printf("j=%d\n",j );
			for(i=0;i<m;i++)
				matrix[i][j]=0;
		}
	}
}