class Solution {
	public ArrayList<String> recrusionGenerate(ArrayList<String> param){
		int oldLength = param.size();
		if(oldLength == 1){
			return param;
		}

		ArrayList<String> res = new ArrayList<>(oldLength / 2);
		for(int i = 0; i < oldLength / 2; i++){
			res.add(i, "(" +  param.get(i) + "," + param.get(oldLength - i - 1) + ")");
		}
		return recrusionGenerate(res);
	}

    public String findContestMatch(int n) {
    	ArrayList<String> param = new ArrayList<>(n);
    	for(int i = 0; i < n; i++){
    		param.add(i, String.valueOf(i + 1));
    	}
    	return recrusionGenerate(param).get(0);
    }
}