class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> sets = new HashSet<String>(wordList);
        if(!sets.contains(endWord)) return 0;
        HashMap<String, ArrayList<String>> maps = new HashMap<String, ArrayList<String>>();
        maps.put(beginWord, getNext(beginWord, sets));
        for(String word: wordList){
            maps.put(word, getNext(word, sets));
        }
        return getDistance(maps, beginWord, endWord);

    }
    public ArrayList<String> getNext(String word, Set<String> sets){
        ArrayList<String> ret = new ArrayList<String>();
        char[] cs = word.toCharArray();
        for(int i = 0; i < cs.length; i++){
            char temp = cs[i];
            for(int j = 0; j < 26; j++){
                if('a' + j != cs[i]) {
                    cs[i] = (char)('a' + j);
                }
                if(sets.contains(new String(cs))) {
                    ret.add(new String(cs));
                }
            }
            cs[i] = temp;
        }
        return ret;
    }
    public int getDistance(HashMap<String, ArrayList<String>> maps, String beginWord, String endWord){
        Set<String> visited = new HashSet<String>();
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        LinkedList<String> queue =new LinkedList<String>();
        queue.addFirst(beginWord);
        distance.put(beginWord, 1);
        visited.add(beginWord);
        while(!queue.isEmpty()){
            String temp = queue.pollLast();
            ArrayList<String> lists = maps.get(temp);
            for(String s : lists){
                if(!visited.contains(s)){
                    if(s.equals(endWord)) {
                        return distance.get(temp) + 1;
                    }
                    distance.put(s, distance.get(temp) + 1);
                    queue.addFirst(s);
                    visited.add(s);
                }
            }
        }
        return 0;
    }
}