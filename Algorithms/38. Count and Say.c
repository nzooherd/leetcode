char* countAndSay(int n) {
   char* s;
	int i,j,k,x;
	short map[10000][2];
	char temp[10000];
	s=(char *)malloc(sizeof(char)*10000);
	s[0]='1';i=1;
	while(i<n){
		memset(temp,'\0',sizeof(temp));
		strcpy(temp,s);
		memset(s,'\0',sizeof(s));memset(map,0,sizeof(map));
		map[0][0]=temp[0]-'0';map[0][1]=1;j=1;k=0;
		while(temp[j]!='\0'){
			if(temp[j]==temp[j-1]){
				map[k][1]++;
			}
			else{
				k++;
				map[k][0]=temp[j]-'0';
				map[k][1]=1;
			}
			j++;
		}
		j=0;
		for(x=0;x<(k+1);x++){
			s[j]='0'+map[x][1];
			j++;
			s[j]='0'+map[x][0];
			j++;
		}
		i++;	
	}
	return s;
}