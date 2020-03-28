bool canPlaceFlowers(int* flowerbed, int flowerbedSize, int n) {
    if(n == 0) return 1;
	int count = 0;
	for(int i = 0; i < flowerbedSize; i++) {
		if(flowerbed[i] == 0 ) {
			if(i == 0 && flowerbed[1] == 0) {
				flowerbed[0] = 1;
				count++;	
				if(count == n) return 1;
			}
			else if(i == flowerbedSize-1 && flowerbed[i-1] == 0) {
				flowerbed[i] = 1;
				count++;
				if(count == n) return 1;
			}
			else if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
				flowerbed[i] = 1;
				count++;
				if(count == n) return 1;
			}
		}
	}
	return 0;
   
}