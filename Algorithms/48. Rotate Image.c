void rotate(int** matrix, int matrixRowSize, int matrixColSize) {
    int **temp,i,j;
	temp=(int **)malloc(sizeof(int*)*matrixRowSize);
	for(i=0;i<matrixRowSize;i++)
		*(temp+i)=(int *)malloc(sizeof(int)*matrixColSize);
	for(i=0;i<matrixRowSize;i++)
		for(j=0;j<matrixColSize;j++)
			temp[i][j]=matrix[i][j];
	for(i=0;i<matrixColSize;i++){
		for(j=0;j<matrixRowSize;j++){
			matrix[i][j]=temp[matrixRowSize-j-1][i];
		}
	}
    
}