class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int operations = 0;
        
        // Keep merging until sorted
        while (true) {
            // Check if already sorted
            boolean sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) break;
            
            // Find minimum sum pair
            int minSum = Integer.MAX_VALUE;
            int minIdx = -1;
            
            for (int i = 0; i < n - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    minIdx = i;
                }
            }
            
            // Merge the pair: replace nums[minIdx] with sum, shift rest left
            nums[minIdx] = minSum;
            for (int i = minIdx + 1; i < n - 1; i++) {
                nums[i] = nums[i + 1];
            }
            n--; // Reduce effective array size
            operations++;
        }
        
        return operations;
    }
}