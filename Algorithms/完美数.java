public class Solution {
    public boolean checkPerfectNumber(int num) {
		int[] mulnum=new int[(int)Math.pow(num,1.0/2)*2+1];
		int i = 0,index = 0,sum = 0;
		for(i = 1;i*i <= num;i++) {
			if(num%i == 0) {
				mulnum[index++] = i;
				if(num/i!=i) mulnum[index++] = num/i;
			}
		}
		for(i =0;i < index;i++){
			if(mulnum[i]!=num) sum += mulnum[i];
		}
		if(num!= 0&&sum == num) return true;
		else return false;
    }
}