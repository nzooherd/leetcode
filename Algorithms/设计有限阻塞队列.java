import java.util.LinkedList;
class BoundedBlockingQueue {
    private LinkedList<Integer> queue;
    private int capacity = 0;

    public BoundedBlockingQueue(int capacity) {
            queue = new LinkedList<Integer>();
            this.capacity = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
            synchronized(queue){
                while(queue.size() == capacity){
                    queue.wait();
                }
                queue.add(element);
                queue.notify();
            }
    }
    
    public int dequeue() throws InterruptedException {
            synchronized(queue){
                while(queue.size() == 0){
                    queue.wait();
                }
                int value = queue.pollFirst();
                queue.notify();
                return value;
            }
    }
    
    public int size() {
            synchronized(queue){
                return queue.size();
            }
    }
}