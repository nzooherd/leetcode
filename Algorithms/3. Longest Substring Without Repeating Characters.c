int lengthOfLongestSubstring(char* s) {
  int len=0,l=0,i,j=0,temp=0,max=0;
		int m[200][2];
		memset(m,0,sizeof(m));
		while(s[len]!='\0')
			len++;
	for(i=0;i+max<len;i++){
			memset(m,0,sizeof(m));
			l=0;
			for(j=i;j<len;j++){
				if(m[(int)s[j]][0]) break;
				else{
				    m[(int)s[j]][0]=1;
					l++;
					if(l>max) max++;
				}
			}
		}
		return max;
}