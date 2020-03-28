public class Solution {
    public int findNthDigit(int n) {
		int i=0,sum=0,bit=0,temp=0,number=0;
		if(n < 10) return n;
		while(n > sum){
			temp = sum;	
			sum += 9*(++bit)*Math.pow(10,bit-1);
		}
		n -= temp;
		number += Math.pow(10,bit-1)+((n-1)/bit);
		n -= (n-1)/bit*bit;
		number /= Math.pow(10,bit-n);
		return number%10;
    }
}