bool isPalindrome(int x) {
   if(x<0) return 0;
	int i=1,k=0,*a;
	while(x/i>=10){
		i*=10;
		k++;
	}
	a=(int*)malloc(sizeof(int)*k+10);
	for(i=0;i<(k+1)/2;i++){
		a[i]=x%10;
		x=x/10;
	}
	if(!(k%2)) x=x/10;
	for(i=(k+1)/2-1;i>=0;i--){
		if(a[i]!=x%10) return 0;
		x=x/10;
	}
	return 1;
}