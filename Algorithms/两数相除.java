public class Solution {
    public int divide(int dividend, int divisor) {
		int flag = 0,i=0,length = 0;
		long r = 0;
		long dividend_temp = dividend;
		long divisor_temp  = divisor;
		if(divisor == 0) return 2147483647;
		if(dividend == 0) return 0;
		if(divisor == 1) return dividend;
		if(dividend == -2147483648 && divisor == -1) return 2147483647;
		if(divisor == -1) {
			dividend -= 1;
			dividend = (dividend^0xffffffff);
			return dividend;
		}
		flag = judge(dividend,divisor);
		if(dividend < 0) {
			dividend_temp = (long)(dividend)-1;
			dividend_temp = (dividend_temp^0xffffffff);
		}
		if(divisor < 0) {
			divisor_temp -= 1;
			divisor_temp = (divisor_temp^0xffffffff);
		}
		System.out.println(dividend_temp);
		System.out.println(divisor_temp);
		if(divisor_temp > dividend_temp) return 0;
		String one = Long.toString(dividend_temp);
		String two = Long.toString(divisor_temp);
		int[] p = new int[one.length()];
		for(i = 0;i < one.length();i++)
			p[i] = one.charAt(i) - '0';
		int[] result = d(p,divisor_temp,two.length());
		for(i = result.length-1;i>=0;i--){
			if(result[i] != 0) break;
		}
		length = result[i];
		System.out.println("length="+length);
		for(i = 0;i < length;i++){
			r = mul(r);
			r += result[i];
		}
		return (int)(r*flag);
    }
	public int judge(int x,int y){
		int r=0;
		if(x>0 && y>0) r = 1;
		if(x>0 && y<0) r = -1;
		if(x<0 && y<0) r = 1;
		if(x<0 && y>0) r = -1;
		return r; 
	} 
	public int[] d(int[] p,long q,int length){
		int[] r = new int[p.length+1];
		int k=0,index=0,i=0;
		long dividend=0;
		while(i < p.length){
			if(dividend < q){
				dividend = mul(dividend);
				dividend += p[i++];
			}
			k = 0;
			while(dividend >= q){
				dividend -= q;
				k++;
			}
			r[index++] = k;
		}
		r[index] = index;
		for(int x:r)
		    System.out.println(x);
		return r;
	}
	public long mul(long x){
		long r =0;
		for(int i=0;i<10;i++)
			r += x;
		return r;	
	}
}