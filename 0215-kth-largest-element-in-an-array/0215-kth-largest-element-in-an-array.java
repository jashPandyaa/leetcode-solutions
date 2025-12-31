class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();    //Remove the smallest element to maintain the heap size as k
            }
        }

        return minHeap.peek(); //The root of minHeap is the kth largest element
    }
}