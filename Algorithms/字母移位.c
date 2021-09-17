#include<stdio.h>
#include<stdlib.h>

char * shiftingLetters(char * S, int* shifts, int shiftsSize){
	char* result = (char *)malloc(sizeof(char) * (shiftsSize + 1));
    memset(result, 0, sizeof(char) * (shiftsSize + 1));
	long sum = 0;
	for(int i = shiftsSize - 1; i >= 0; i--){
		result[i] = 'a' +  (S[i] - 'a' + sum + shifts[i]) % 26;
		sum += shifts[i];
	}
    return result;
}