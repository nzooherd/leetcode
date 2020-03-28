int compareVersion(char* version1, char* version2) {
	int l1 = 0, l2 = 0;
	if(version1[0] == '\0' || version2[0] == '\0') {
		int length1 = 0, length2 = 0;
		int count1 = 0, count2 = 0;

		for(; version1[length1] != '\0'; length1++) {
		}
		for(; version2[length2] != '\0'; length2++) {
		}
		
		for(; count1 < length1 && (version1[count1] == '0' || version1[count1] == '.'); count1++);

		for(; count2 < length2 && (version2[count2] == '0' || version2[count2] == '.'); count2++);
	
	    printf("%d %d %d %d", length1, count1, length2, count2);
		if(length1 - count1 == length2 - count2) return 0;
		else if(length1 - count1 < length2 - count2) return -1;
		else return 1;
	}
	while(version1[++l1] != '\0') ;
	while(version2[++l2] != '\0') ;
	int flag1 = -1, flag2 = -1;
	int flag1Of0 = 0, flag2Of0 = 0;
	for(; flag1Of0 < l1; flag1Of0++) {
		if(version1[flag1Of0] != '0') break;
	}
	for(; flag2Of0 < l2; flag2Of0++) {
		if(version2[flag2Of0] != '0') break;
	}
	for(int i = 0; i < l1; i++) {
		if(version1[i] == '.') {
			flag1 = i;
			break;
		}
	}
	for(int i = 0; i < l2; i++) {
		if(version2[i] == '.') {
			flag2 = i;
			break;
		}
	}
	if(flag1 == -1) flag1 = l1-1;
	else flag1--;
	if(flag2 == -1) flag2 = l2-1;
	else flag2--;
	if(flag1 - flag1Of0 < flag2 - flag2Of0) return -1;
	else if(flag1 - flag1Of0 > flag2 - flag2Of0) return 1;
	else {
		int ans = compareLengthEqual(version1, version2, flag1Of0, flag1, flag2Of0, flag2);
		if(ans != 0) return ans;
		else {
			if(flag1 == l1-1) flag1--;
			if(flag2 == l2-1) flag2--;
		    return compareVersion(version1+flag1+2, version2+flag2+2);
		}
	}
	return 0;
}
int compareLengthEqual(char* v1, char* v2, int f1Of0, int f1, int f2Of2, int f2)
{
	for(int i = f1Of0, j = f2Of2; i <= f1 && j <=f2; i++, j++) {
		if(v1[i] < v2[j]) return -1;
		if(v1[i] > v2[j]) return 1;
	}
	return 0;
}
