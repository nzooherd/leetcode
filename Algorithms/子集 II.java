public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		if(nums.length == 0) return null;
		ans.add(new ArrayList<Integer>());
		ArrayList<Integer> tp= new ArrayList<Integer>();
		tp.add(nums[0]);
		ans.add(tp);
		int flag = nums[0],start = 1;
		int temp = 0;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == flag) {
			    temp = ans.size();
				comb(ans,nums[i],start);
				start = temp;
			}
			else {
			    temp = ans.size();
				comb(ans,nums[i]);
				start = temp;
			}	
			flag = nums[i];
		}
		return ans;
    }
	public void comb(List<List<Integer>> pre, int x, int start) {
	        int size = pre.size();
    		for(int i = start; i < size; i++) {
    			ArrayList<Integer> temp = new ArrayList<Integer>(pre.get(i));
    			temp.add(x);
    			pre.add(temp);
    		}
	}
	public void comb(List<List<Integer>> pre, int x){
	    System.out.println("pre:"+pre);
	    int size = pre.size();
	    for(int i = 0; i < size; i++) {
    			ArrayList<Integer> temp = new ArrayList<Integer>(pre.get(i));
    			temp.add(x);
    			System.out.println("temp:"+temp);
    			pre.add(temp);
    	}
    				System.out.println(pre);
	}
}