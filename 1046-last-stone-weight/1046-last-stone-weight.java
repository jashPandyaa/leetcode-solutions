class Solution {
    public int lastStoneWeight(int[] stones) {
        //Create max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        //add all stones into Heap
        for(int stone : stones){
            maxHeap.add(stone);
        }

        //Continuosly add and smash the two heaviest stones
        while(maxHeap.size() > 1){
            int y = maxHeap.poll(); //the heaviest stones
            int x = maxHeap.poll(); //the second heaviest stones

            if( x != y){
                maxHeap.add(y - x); //add remaining stone back to the heap
            }
        }

        //return the weight of the last remaining stone or 0 if no stones are left
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}