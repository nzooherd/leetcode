int findDerangement(int n) 
{
	if(n == 0 || n == 1) return 0;
	if(n == 2) return 1;
	int mod = 1000000007;
	long int ans, p = 0, q = 	1;
	for(int i = 3; i <= n; i++) {
		ans = (i-1) * ((p + q) % mod) % mod;
		p = q;
		q = ans;
	}
	return (int)ans;
}