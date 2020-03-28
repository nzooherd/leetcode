bool searchMatrix(int** matrix, int matrixRowSize, int matrixColSize, int target) {
	int i,left,right,medium,m,n;
	m=matrixRowSize;n=matrixColSize;
	for(i=0;i<m;i++){
		if(target<=matrix[i][n-1]) break;
	}
	if(i==m) return 0;
	left=0;right=n-1;
	while(left<=right){
		medium=(left+right)/2;
		if(matrix[i][medium]<target) left=medium+1;
		else if(matrix[i][medium]>target) right=medium-1;
		else  return 1;
	}
	return 0;
}