class Trie {
    class Node{
        public Node[] nexts = new Node[26];
        public char value;
        public boolean end;
    }

    private Node head;

    /** Initialize your data structure here. */
    public Trie() {
        head = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node p = head;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(p.nexts[c - 'a'] == null){
                p.nexts[c - 'a'] = new Node();
                p.nexts[c - 'a'].value = c;
                p.nexts[c - 'a'].end = false;
            }
            if(i == word.length() - 1) {
                p.nexts[c - 'a'].end = true;
            }
            p = p.nexts[c - 'a'];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node p = head;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (p.nexts[c - 'a'] == null) {
                return false;
            }
            if(i == word.length() - 1 && p.nexts[c - 'a'].end){
                return true;
            }
            p = p.nexts[c - 'a'];
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node p = head;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if (p.nexts[c - 'a'] == null) {
                return false;
            }
            p = p.nexts[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */