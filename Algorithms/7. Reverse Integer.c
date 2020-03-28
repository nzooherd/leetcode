int reverse(int x) {
    int flag=0,i=1,k=0;
	long int sb=0;
	short a[10000];
	if(x<0){
		x=(-1)*x;
		flag=1;
	}
	while(x/i){
		a[k]=x%10;
		k++;
		x=(x-x%10)/10;
	}
	for(i=0;i<k;i++){
		sb*=10;
		sb+=a[i];
	}
	if(flag) sb*=-1;
	if(sb>2147483647||sb<-2147483647) return 0;
	return (int)sb;
    
}