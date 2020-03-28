int swt(char c)
{
	if(c=='I') return 1;
	else if(c=='V') return 5;
	else if(c=='X') return 10;
	else if(c=='L') return 50;
	else if(c=='C') return 100;
	else if(c=='D') return 500;
	else  return 1000;
}
int romanToInt(char* s) {
   int r=0;	
	int l=0,i=0,tmp;
	while(s[l]!='\0')
		l++;
	for(i=0;i<l-1;i++){
		if(swt(s[i])>=swt(s[i+1])) tmp=swt(s[i]);
		else tmp=(-1)*swt(s[i]);
		r+=tmp;
	}
	r+=swt(s[l-1]);
	return r;
    
}