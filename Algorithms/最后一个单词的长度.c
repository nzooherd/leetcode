int lengthOfLastWord(char* s) {
int l=0,num=0,i;
	if(s[0]=='\0') return 0;
	while(s[l++]!='\0')
	for(i=l-1;i>=0;i--){
		if(s[i]!=' ') break;
	}
	for(;i>=0;i--){
		if(s[i]!=' ') num++;
		else break;
	}
	return num;
}