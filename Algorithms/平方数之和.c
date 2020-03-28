bool judgeSquareSum(int c) 
{
	int flag = 0;
	while(flag * flag >= 0 && flag * flag <= c ) flag++;
	flag--;
	for(int i = 0, j = flag; i <= j; ) {
		long int temp = i*i + j*j;
		if(temp == c) return 1;
		else if(temp < c) i++;
		else j--;
	}
	return 0;
}