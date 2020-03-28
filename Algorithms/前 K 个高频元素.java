public class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for(int i : nums) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}
			else map.put(i, 1);
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (-1) * (o1.getValue() - o2.getValue());
			}
		});
		List<Integer> ans = new ArrayList<Integer>();
		Iterator<Map.Entry<Integer, Integer>> it = list.iterator();
		for(int i = 0; i < k && it.hasNext(); i++){
			ans.add(((Map.Entry<Integer, Integer>)it.next()).getKey());
		}
		return ans;
	}
}