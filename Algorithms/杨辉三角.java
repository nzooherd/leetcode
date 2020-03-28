import java.util.*;
public class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> one = new ArrayList<Integer>();
		one.add(1);
		if(numRows >= 1) ans.add(one);
		for(int i = 1; i < numRows; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			List<Integer> last = ans.get(ans.size()-1);
			temp.add(1);
			for(int j = 0; j < last.size()-1; j++)
				temp.add(last.get(j) + last.get(j+1));
			if(i != 0) temp.add(1);
			ans.add(temp);
		}	
		return ans;
	}
}