char* longestPalindrome(char* s) {
    int i,j,l=0,len=0,max=0,flag,k=0,sb;
	char* S;
	char temp[1010],b[1010];
	S=(char*)malloc(sizeof(char)*1100);
	memset(temp,'\0',sizeof(temp));memset(b,'\0',sizeof(b));
	while(s[l]!='\0'){
		l++;
	}
	for(i=0;i+max<=l;i++){
		if(1){
			flag=0;memset(b,'\0',sizeof(b));k=0;;len=0;
			for(j=0;i-j>=0&&i+j<=l;j++){
				if(s[i-j]==s[i+j]){
					len++;
					b[k]=s[i+j];
					k++;
					if(max<len){
						max=len;sb=1;
						flag=1;
					}
				}
				else break;
			}
			if(flag){
				memset(temp,'\0',sizeof(temp));
				strcpy(temp,b);
			}
		}
		if(1){
			flag=0;memset(b,'\0',sizeof(b));k=0;len=0;
			for(j=0;i-j>=0&&i+j+1<=l;j++){
				if(s[i-j]==s[i+j+1]){
					len++;
					b[k]=s[i+j+1];
					k++;
					if(max<=len){
						max=len;sb=2;
						flag=2;
					}
				}
				else break;
			}
			if(flag){
				memset(temp,'\0',sizeof(temp));
				strcpy(temp,b);
			}

		}
	}
	if(sb==2){
		for(i=0;i<max-!(sb-1);i++){
			S[i]=temp[max-1-i];
		}
		S[i]='\0';
		strcat(S,temp);
	}
	if(sb==1){
		for(i=0;i<max-1;i++){
			S[i]=temp[max-i-1];
		}
		S[i]='\0';
		strcat(S,temp);
	}
	return S;
    
}