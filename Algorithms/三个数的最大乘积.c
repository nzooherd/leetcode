void findMin(int *a, int *b, int *c)
{
	int tempa = *a, tempb = *b, tempc = *c;
	*a = (tempa > tempb ? (tempa > tempc ? tempa : tempc) : (tempb > tempc ? tempb : tempc));
	*c = (tempa < tempb ? (tempa < tempc ? tempa : tempc) : (tempb < tempc ? tempb : tempc));
	*b = (tempa + tempb + tempc - *a - *c);
}
void findMax(int *a, int *b)
{
	if(*a < *b) return;
	int temp = *a;
	*a = *b;
	*b = temp;
}
int maximumProduct(int* nums, int numsSize) {
	    int a = nums[0], b = nums[1], c = nums[2];
	    int x = nums[0], y = nums[1];
	    findMin(&a, &b, &c);
	    findMax(&x, &y);
	    for(int i = 2; i < numsSize; i++) {
	    	if(i != 2 && nums[i] > c) {
	    		c = nums[i];
	    		findMin(&a, &b, &c);
	    	}
	    	if(nums[i] < y) {
	    		y = nums[i];
	    		findMax(&x, &y);
	    	}

	    }
	    int max = a > b ? (a > c ? a : c) : (b > c ? b : c);
	    return (max * b * c > max * x * y ? max * b * c : max * x * y);
}
