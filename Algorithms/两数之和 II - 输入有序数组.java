public class Solution {
    public int[] twoSum(int[] numbers, int target) {
		int i=0,k=0,end=numbers.length-1;
		int[] r = new int[2];
		for(i = 0;i <= end;i++){
			for(k = end;numbers[k]+numbers[i]>target;k--) {
			}
			if(numbers[i] + numbers[k] == target) break;
			else end = k+1;
			if(end > numbers.length-1) end = numbers.length-1;
		}
		r[0] = i+1;
		r[1] = k+1;
		return r;	
    }
}