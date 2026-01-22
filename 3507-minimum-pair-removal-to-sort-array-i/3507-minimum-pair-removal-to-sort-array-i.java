class Solution {
    public int minimumPairRemoval(int[] nums) {
        //BruteForce : Time comp - O(n ^ 3)
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        int operations = 0;
        
        while (!isSorted(list)) {
            // Find the adjacent pair with minimum sum
            int minSum = Integer.MAX_VALUE;
            int minIndex = 0;
            
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    minIndex = i;
                }
            }
            
            // Replace the pair with their sum
            list.set(minIndex, minSum);
            list.remove(minIndex + 1);
            
            operations++;
        }
        
        return operations;
    }
    
    private boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}