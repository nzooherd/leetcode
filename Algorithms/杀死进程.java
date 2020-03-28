public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		int[] son = new int[pid.size()];
		int[] par = new int[ppid.size()];
		HashMap<Integer,ArrayList<Integer>> relt = new HashMap<Integer,ArrayList<Integer>>();
		int index = 0;
		for(Integer i : pid) {
			son[index++] = i;
		}
		index = 0;
		for(Integer i : ppid) {
			par[index++] = i;
		}
		for(int i = 0; i < pid.size(); i++){
			if(relt.containsKey(par[i])) {
				relt.get(par[i]).add(son[i]);
			}
			else {
			    ArrayList<Integer> temp = new ArrayList<Integer>(1);
			    temp.add(son[i]);
			    relt.put(par[i],temp);
			}
		}
		ArrayList<Integer> ans = search(relt,kill);
		return ans;
    }
 	public ArrayList<Integer> search(HashMap<Integer,ArrayList<Integer>> relt, int kill){
		ArrayList<Integer> ans = new ArrayList<Integer>(1);
		ans.add(kill);
		if(!relt.containsKey(kill)) return ans;
		for(Integer i : relt.get(kill)) {
			ans.addAll(search(relt,i));
		}
		return ans;

	}
}