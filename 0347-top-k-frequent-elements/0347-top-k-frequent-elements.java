class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Edge case: if k equals array length, return entire array
        if(k == nums.length){
            return nums;
        } 

        // HashMap to store: Key = number, Value = frequency
        HashMap<Integer, Integer> count = new HashMap<>();

        // Count frequency of each number
        for(int i = 0; i < nums.length; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }   

        // Min-heap: keeps smallest frequency elements at top
        // Comparator: (a,b) -> count.get(a) - count.get(b) creates min-heap
        Queue<Integer> heap = new PriorityQueue<>(
            (a, b) -> count.get(a) - count.get(b));

        // Add all unique numbers to heap
        for(int n : count.keySet()){
            heap.add(n);
            // Keep only top k frequent elements by removing smallest frequency
            if(heap.size() > k){
                heap.poll();  // Remove element with lowest frequency
            }
        }

        // Build result array from heap (contains k most frequent elements)
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = heap.poll();
        }

        return ans;
    }
}