class Node{
    int frequence;
    int value;
    Node next;
    Node pre;
}

class LFUCache {
    int HashMap<int, Node> cache = new HashMap<>();
    int capacity;
    Node head = new Node();
    Node tail = head;

    public LFUCache(int capacity) {
        this.capacity = capacity
    }
    
    public int get(int key) {
        Node node = this.cache.get(node)
        if(node == null){
            return -1
        }
        addFrequency(node)
    }
    
    public void put(int key, int value) {
        if(this.cache.length() >= capacity){
            int value = tail.value
            cache.remove(value)
            if(tail != head){
                tail = tail.pre;
                tail.next = null
            }
        }
        Node node = new Node()
        node.value = key
        node.frequence = 0
        node.pre = tail
        tail.next = node
    }

    public void addFrequency(Node node){
        node.frequence += 1
        if(node.pre != head){
            Node pre = node.pre
            pre.next = node.next
            while(pre != head && pre.frequence <= node.frequence){
                pre = node.pre
            }
            node.next = pre.next
            node.next.pre = node
            pre.next = node
            node.pre = pre
        }
        while(tail.next != null){
            tail = tail.next
        }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */