int minimumTotal(int** triangle, int triangleRowSize, int *triangleColSizs) {
	int i=0,r=10000,j=0;
	int m[10000],temp[10000];
	memset(m,0,sizeof(m));memset(temp,0,sizeof(temp));
	for(i=0;i<triangleRowSize;i++){
		for(j=0;j<=i;j++)
			temp[j]=m[j];
		for(j=0;j<=i;j++){
			if(!j) m[j]=temp[j]+triangle[i][0];
			else if(j==i) m[j]=temp[j-1]+triangle[i][j];
			else{
				m[j]=triangle[i][j]+(temp[j]<temp[j-1]?temp[j]:temp[j-1]);
			}
		}
	}
	for(i=0;i<triangleRowSize;i++)
		if(r>m[i]) r=m[i];
	return r;
}   