class MedianFinder {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    //Add a number into the data structure
    public void addNum(int num) {
        maxHeap.offer(num); 

        minHeap.offer(maxHeap.poll()); //balancing step

        if(maxHeap.size() < minHeap.size()){ //maintain size property
            maxHeap.offer(minHeap.poll());
        }
    }

    //Return the median of current data stream
    public double findMedian() {    
        //either odd stream than maxHeap else even stream than addition of first 2 digits
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */