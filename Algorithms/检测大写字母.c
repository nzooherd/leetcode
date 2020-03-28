bool detectCapitalUse(char* word) {
	int length = 0, count = 0;
	for(; word[length] != '\0'; length++) {
		if(word[length] < 'A' && word[length] > 'Z' && word[length] < 'a' && word[length] > 'z') return 0;
		if(word[length] >= 'A' && word[length] <= 'Z') count++;
		if(word[0] >= 'A' && word[0] <= 'Z' && !(count == length+1 || count == 1)) return 0; 
		if(word[0] >= 'a' && word[0] <= 'z' && count >= 1) return 0;
	}
	return 1;  
}