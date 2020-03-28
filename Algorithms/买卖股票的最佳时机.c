int maxProfit(int* prices, int pricesSize) {
	int max=0,i=0,min=100000;
	for(i=0;i<pricesSize;i++){
		if(prices[i]<min) min=prices[i];
		if(prices[i]-min>max){
			max=prices[i]-min;
		}
	}
	return max;
}