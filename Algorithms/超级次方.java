public class Solution {
	public int superPow(int a,int[] b){
		int r = 1;
		a %= 1337;
		if(b.length == 1) {
			int d = b[0];
			while(d > 0){
				r *= (a%1337);
				r %= 1337;
				d--;
			}	
		}
		else {
			if((b[b.length-1]-0)%2 == 1) {
				r = (a%1337) * superPow(a%1337*(a%1337)%1337,don(b))%1337;
			}
			else r = superPow(a%1337*(a%1337)%1337,don(b))%1337;

		}
		return r%1337;
	}
	public int[] don(int[] n){
		int length=0,temp=0,i=0,index=0;
		if(n[0] >= 2) length=n.length;
		else length = n.length-1; 
		int[] r = new int[length];
		if(length == n.length-1) {
		    i = 1;
		    temp = n[0];
		}
		for(;i<n.length;i++){
			temp *= 10;
			temp += n[i];
			r[index++] = temp/2;
			temp = (temp%2);
		}
        for(i = index; i < length; i++)
            r[i] = 0;
		return r;
	}
}