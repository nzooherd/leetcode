int C(int numsSize)
{
	int r=1;
	while(numsSize){
		r*=(numsSize--);
	}
	return r;
}
char* getPermutation(int n, int k) {
int *num,*map,*r;
	char *a;
	int j,size=0,i,count,nmb=-1,flag;
	count=C(n);
	num=(int*)malloc(sizeof(int)*n);
	map=(int*)malloc(sizeof(int)*n);
	r=(int*)malloc(sizeof(int)*n);
	a=(char*)malloc(sizeof(char)*(n+2));
	for(i=0;i<n;i++)
		a[n]='\0';
	for(i=0;i<n;i++){
		num[i]=i+1;	
		map[i]=0;
	}
	k--;
	for(i=n-1;i>=0;i--){
		count=C(i);
		flag=k/count;
		k-=flag*count;
		nmb=-1;
		for(j=0;j<n;j++){
			if(!map[j]){
				nmb++;
			}
			if(nmb==flag){
				map[j]=1;
				break;
			}
		}
		r[size]=num[j];size++;
	}
	for(i=0;i<n;i++)
		a[i]=r[i]+'0';
	return a;
		
}