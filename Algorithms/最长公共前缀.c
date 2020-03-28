char* longestCommonPrefix(char** strs, int strsSize) {
	if(!strsSize) return "";
	if(strsSize==1) return strs[0];
	char *s;
	int i,j,k,max=0,flag=0;
	for(i=0;strs[0][i]!='\0'&&!flag;i++){
		for(j=1;j<strsSize;j++){
			if(strs[j][i]=='\0'||strs[j][i]!=strs[0][i]){
				flag=1;
				break;
			}
		}
		if(j==strsSize) max=i+1;
	}
	printf("max=%d\n",max);
	s=(char*)malloc(sizeof(char)*(max+1));
	for(i=0;i<=max;i++)
		s[i]='\0';
	for(i=0;i<max;i++){
		s[i]=strs[0][i];
	}
	return s;
    
}