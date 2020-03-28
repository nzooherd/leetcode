char* minWindow(char* s, char* t) {
	int* map = (int*)malloc(sizeof(int)*127);
	int* mapCopy = (int*)malloc(sizeof(int)*127);
	int lengthS = 0, lengthT = 0, count = 0, index = 0;
	while(s[lengthS++] != '\0') ; lengthS--;
	while(t[lengthT++] != '\0') ; lengthT--;
	if(lengthS < lengthT) return (char*)malloc(sizeof(char) * 1);
	int* number = (int*)malloc(sizeof(int) * lengthS);

	for(int i = 0; i < 127; i++){
		map[i] = 0;
		mapCopy[i] = 0;
	}

	for(int i = 0; t[i] != '\0'; i++) {
		map[t[i]]++;	
	}
	for(int i = 0; s[i] != '\0'; i++) {
		if(map[s[i]] > 0) {
			number[index++] = i;
			if(mapCopy[s[i]] < map[s[i]]) {
				count++;
			}
			mapCopy[s[i]]++;
		    if(count == lengthT) 
				break;
		}
	}
	if(count != lengthT) return (char*)malloc(sizeof(char) * 1);
	int left = 0;
	int min = number[index-1] - number[left] + 1, flag = number[index-1];
	for(int i = number[index-1]; i < lengthS; ) {
	    printf("%d %d\n", mapCopy[s[number[left]]],map[s[number[left]]]);
		while(--mapCopy[s[number[left]]] >= map[s[number[left]]]) {
			if(number[index-1] - number[left+1] + 1< min) {
				min = number[index-1] - number[left+1] + 1;
				flag = number[index-1];
			}
			left++;
		}
		char c = s[number[left]];
		printf("c = %c\n",c );
		while(i < lengthS ) {
		    i++;
			if(map[s[i]] >= 1) {
				number[index++] = i;
				mapCopy[s[i]]++;
			}
			if(s[i] == c) break;
		}
		if(i == lengthS) break;
		else if(number[index-1] - number[left+1] + 1 < min) {
				min = number[index-1] - number[left+1] + 1;
				printf("%d\n",number[index-1] );
				flag = number[index-1];		
		}
		left++;
	}
	printf("%d %d\n",min, flag );
	char* ans = (char*)malloc(sizeof(char) * (min+1));
	for(int i = flag; i > flag - min; i--) {
		ans[min - flag + i - 1] = s[i];
		printf("%c",s[i]);
	}
	ans[min] = '\0';
	return ans; 
}