class MedianFinder {
    Queue<Integer> small = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });
    Queue<Integer> large = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public MedianFinder(){

    }

    public void addNum(int num){
        large.add(num);
        small.add(large.poll());
        if(small.size() - large.size() > 1){
            large.add(small.poll());
        }
    }
    public double findMedian(){
        int smallSize = small.size();
        int largeSize = large.size();
        if(largeSize == 0) return smallSize == 0 ? -1 : small.peek();
        if((smallSize + largeSize) % 2 == 1){
            return small.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */