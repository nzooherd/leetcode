int mySqrt(int x) {
	double medium=0,left,right,temp=0;
	left=0;right=x;
	while(right-left>0.001){
		medium=(left+right)/2;
		if(medium*medium<x) left=medium;
		else if(medium*medium>x) right=medium;
		else return medium;
	}
	if((int)(medium+1)*(int)(medium+1)==x) return (int)(medium+1);
	return (int)medium;
}