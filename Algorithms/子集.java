public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> map = new ArrayList<List<Integer>>(); 
		int length = nums.length,index=0;
		long i=0,flag=0;
		double sum = Math.pow(2,length);
		for(i = 0;i < sum;i++){
			List<Integer> temp=new ArrayList<Integer>();
			flag = i;
			index = 0;
			while(flag != 0){
				if((flag&1) == 1){
					temp.add(nums[index]);
				}	
				index++;
				flag >>>= 1;
			}
			map.add(temp);
		} 
		return map;
    }
}