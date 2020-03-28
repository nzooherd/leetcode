
class LRUCache {
    class Node{
    public int value;
    public int key;
    public Node next;
    public Node previous;
}
     private Node head = new Node();
     private Node tail = head;
     private int size = 0;
     private int capacity;
     private HashMap<Integer, Node> cache = new HashMap<>();

     public LRUCache(int capacity) {
        if(capacity <= 0) {
            throw new RuntimeException("Capacity is error");
        }
        this.capacity = capacity;
     }

     public int get(int key) {
         if(!cache.containsKey(key)) return -1;
         Node p = cache.get(key);

         deleteNode(p);
         addFirstNode(p);

         return p.value;
     }

     public void put(int key, int value) {
         if(cache.containsKey(key)){
             Node p = cache.get(key);
             deleteNode(p);
         } else {
             if(size >= capacity){
                 cache.remove(tail.key);
                 tail = tail.previous;
                 tail.next = null;
                 size--;
             }
         }
         Node node = new Node();
         node.value = value;
         node.key = key;
         addFirstNode(node);
         cache.put(key, node);
     }

     private void deleteNode(Node p){
         if(tail == p){
             tail = tail.previous;
         }
         p.previous.next = p.next;
         if(p.next != null) p.next.previous = p.previous;
         size--;
     }
     private void addFirstNode(Node p){
         p.next = head.next;
         p.previous = head;
         head.next = p;
         if(p.next != null) {
             p.next.previous = p;
         }
         size++;

         if(tail.next != null){
             tail = tail.next;
         }
     }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */