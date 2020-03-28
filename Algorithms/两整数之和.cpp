class Solution {
public:
    int getSum(int a, int b) {
		int temp=0;
		while(b != 0){
			temp = a;
			a = a^b;
			b = (temp&b)<<1;
		}	
		return a;
	}
};