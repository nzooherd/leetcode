bool isValid(char* s) {
   char map[1000];
	memset(map,'\0',sizeof(map));
	int i,k=0,len=0;
	while(s[len]!='\0')
		len++;
	for(i=0;i<len;i++){
		if(s[i]=='('){
			map[k]='(';
			k++;
		}
		else if(s[i]=='['){
			map[k]='[';
			k++;
		}
		else if(s[i]=='{'){
			map[k]='{';
			k++;
		}
		else if(s[i]==')'){
			if(map[k-1]!='(') return 0;
			else{
				map[k-1]='\0';
				k--;
			}
		}
		else if(s[i]==']'){
			if(map[k-1]!='[') return 0;
			else{
				map[k-1]='\0';
				k--;
			}
		}
		else if(s[i]=='}'){
			if(map[k-1]!='{') return 0;
			else{
				map[k-1]='\0';
				k--;
			}
		}
	}
	if(!k) return 1;
	else return 0;
}