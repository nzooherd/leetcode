int strStr(char* haystack, char* needle) {
   char *p;
	p=strstr(haystack,needle);
	if(p==NULL) return -1;
	else return (p-haystack);
    
}