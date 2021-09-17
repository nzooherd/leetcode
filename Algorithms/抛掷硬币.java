class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
    	ArrayList<HashMap<Integer, Double>> probes = new ArrayList<HashMap<Integer, Double>>(prob.length);
    	for(int i = 0; i < prob.length; i++){
    		probes.add(i, new HashMap<Integer, Double>());
    	}
    	for(int i = 0; i < prob.length; i++){
    		if(i == 0){
    			probes.get(i).put(0, 1 - prob[i]);
    			probes.get(i).put(1, prob[i]);
    			continue;
    		}

    		for(int j = 0; j <= (i + 1); j++){
    			HashMap<Integer, Double> lastProbs = probes.get(i-1);
    			double curProb = 0;
    			curProb += lastProbs.getOrDefault(j, 0.0) * (1 - prob[i]);
    			if(j > 0){
    				curProb += lastProbs.get(j - 1) * (prob[i]);
    			}
                probes.get(i).put(j, curProb);
    		}
    	}

    	return probes.get(prob.length - 1).get(target);
    }
}
