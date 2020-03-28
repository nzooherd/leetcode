public class Solution {
    public String getHint(String secret, String guess) {
		int i = 0, j = 0;
		int bull = 0, cows = 0;
		if(secret.length() == guess.length()){
			i = 0;
			j = 0;
		}
		else if(secret.length() < guess.length()) {
			i = guess.length() - secret.length();
			j = 0;
		}
		else{
			i = 0;
			j = secret.length() - guess.length();
		}
		while(i < secret.length() && j < guess.length()) {
			if(secret.charAt(i) == guess.charAt(j)) bull++;
			i++;
			j++;
		}
		HashMap<Character,Integer> mapsec = new HashMap<Character,Integer>();
		HashMap<Character,Integer> mapgue = new HashMap<Character,Integer>();
		for(int x = 0; x < secret.length(); x++){
			char y = secret.charAt(x);
			if(!mapsec.containsKey(y)) {
				mapsec.put(y,1);
			}
			else {
				mapsec.put(y,mapsec.get(y)+1);
			}
		}
		for(int x = 0; x < guess.length(); x++) {
			char y = guess.charAt(x);
			if(!mapgue.containsKey(y)) {
				mapgue.put(y,1);
			}
			else {
				mapgue.put(y,mapgue.get(y)+1);
			}
		}
		for(Map.Entry<Character,Integer> entry : mapsec.entrySet()) {
			if(mapgue.containsKey(entry.getKey())) {
				cows += Math.min(entry.getValue(), mapgue.get(entry.getKey()));
			}
		}
		cows -= bull;
		StringBuilder s = new StringBuilder();
		s.append(Integer.toString(bull));
		s.append("A");
		s.append(Integer.toString(cows));
		s.append("B");
		return s.toString();
    }
}