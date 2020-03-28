public class Solution {
    public int nthUglyNumber(int n) {
		int r=0;
			int[] map=new int[n];
			map[0] = 1;
			int i=0,flag=0,index2=0,index3=0,index5=0;
			int factor3=3,factor5=5,factor2=2;
			for(i=1;i<n;i++){
				flag = Math.min(Math.min(factor2,factor3),factor5);
				map[i] = flag;
				if(flag == factor2){
					factor2 = 2*map[++index2];
				}
				if(flag == factor3){
					factor3 = 3*map[++index3];
				}	
				if(flag == factor5){
					factor5 = 5*map[++index5];
				}
			}
			r = map[n-1];
		return r;
    }
}