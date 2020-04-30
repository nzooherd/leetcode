import java.util.*;
class Node{
    int frequence;
    int value;
    int key;
    Node next;
    Node pre;
}

class LFUCache {
    HashMap<Integer, Node> cache = new HashMap<>();
    int capacity;
    Node head = new Node();
    Node tail = head;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(this.capacity <= 0){
            return -1;
        }


        Node node = this.cache.get(key);
        if(node == null){
            return -1;
        }
        addFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(this.capacity <= 0){
            return;
        }

        if (this.cache.get(key) != null){
            Node node = this.cache.get(key);
            node.value = value;
            addFrequency(node);
            return;
        }

        if(this.cache.size() >= capacity){
            int tailKey = tail.key;
            cache.remove(tailKey);
            if(tail != head){
                tail = tail.pre;
                tail.next = null;
            }
        }
        Node node = new Node();
        node.value = value;
        node.key = key;
        node.frequence = 0;
        node.pre = tail;
        tail.next = node;
        addFrequency(node);
        cache.put(key, node);
    }

    public void addFrequency(Node node){
        node.frequence += 1;
        if(node.pre != head){
            Node pre = node.pre;
            pre.next = node.next;
            if(node.next != null){
                node.next.pre = pre;
            }
            while(pre != head && pre.frequence <= node.frequence){
                pre = pre.pre;
            }
            node.next = pre.next;
            if(node.next != null){
                node.next.pre = node;
            }
            pre.next = node;
            node.pre = pre;
        }
        while(tail.next != null){
            tail = tail.next;
        }
    }

    public String toString(){
        String value = "";
        Node tempHead = head.next;
        while(tempHead != null){
            value +=  String.valueOf(tempHead.value) + "->";
            tempHead = tempHead.next;
        }
        return value;
    }

}