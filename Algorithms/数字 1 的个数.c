int countDigitOne(int n) {
	if(n < 1) return 0;
	int result = 0;
	long m = 10;
	while(n / (m/10) != 0) {
		int flag = n % m / (m / 10);
		if(flag > 1) {
			result += m / 10 * (n / m + 1);
		}
		else if(flag == 0){
			result += m / 10 * (n / m);
		}
		else {
			result += m / 10 * (n / m) + (n % (m / 10) + 1);
		}
		m *= 10;
	}
	return result;

}