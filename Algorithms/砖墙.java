public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
		if(wall == null) return 0;
		if(wall.size() == 1) {
            if(wall.get(0).size() == 1) return 1;
            else return 0;
		}
		int sum = 0, max = 0;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < wall.get(0).size(); i++)
			sum += wall.get(0).get(i);
		for(int i = 0; i < wall.size(); i++) {
			sum = 0;
			for(int k = 0; k < wall.get(i).size()-1; k++) {
				sum += wall.get(i).get(k);
				if(map.containsKey(sum)) {
					map.put(sum,map.get(sum)+1);
				}
				else map.put(sum,1);
			}
		}
		for(Integer value : map.values()) {
			max = Math.max(max,value);
		}
		return wall.size()-max;
    }
}