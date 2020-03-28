int climbStairs(int n) {
 int r,x=0,y=1,i=0;
		while(i<n){
			r=x+y;
			x=y;
			y=r;
			i++;
		}
		return r;
}