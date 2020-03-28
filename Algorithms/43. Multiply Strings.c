int C(char c)
{
	return c-'0';
}
char* multiply(char* num1, char* num2) {
    int *s;
	char *a;
	s=(int *)malloc(sizeof(int)*10000);	
	a=(char *)malloc(sizeof(char)*10000);
	int l1=0,l2=0,i,j,tmp=0,size=0;
	while(num1[l1++]!='\0') ;
	while(num2[l2++]!='\0') ;
	l1-=1;l2-=1;
	for(i=0;i<l1+l2-1;i++){
		for(j=(0>(i-(l2-1))?0:(i-(l2-1)));j<=i&&j<l1;j++){
			tmp=C(num1[l1-j-1])*C(num2[l2-(i-j)-1]);
			s[i]+=tmp;
		}
		s[i+1]+=s[i]/10;
		s[i]=s[i]%10;
	}
    if(s[i]) i++;
	while(!s[i-1]&&i>=2) i--;
	size=i;
	for(i=0;i<size;i++){
		a[i]=s[size-1-i]+'0';
	}
	return a;
}