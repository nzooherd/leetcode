public class Solution {
    public int countPrimes(int n) {
			int r = 0,temp = 0,i = 0;
			int[] flag = new int[n];
			for(i = 2;i < n;i++){
				if(flag[i] == 1) continue;
				r++;
				temp = i*2;
				while(temp < n){
					flag[temp] = 1;
					temp += i;
				}
			}
			return r;
    }

	
}