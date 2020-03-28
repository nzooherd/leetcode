public class Solution {
    public int numSquares(int n) {
		int[] map=new int[n+1];
		int i=0,k=0;
		for(i=0;i*i <= n;i++){
			map[i*i] = 1;
			if(i*i == n) return 1;
		}
		for(i = 1;i <=n;i++){
			if(map[i] == 0){
				map[i] = Integer.MAX_VALUE;
				for(k=1;k<=i/2;k++){
					if(map[i] > map[i-k]+map[k]) map[i]=map[i-k]+map[k];
				}
			}
		}
		return map[n];
    }
}