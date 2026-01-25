class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        
        Arrays.sort(nums);
        
        int minDiff = Integer.MAX_VALUE;
        
        // After sorting, min difference will be between elements
        // that are k-1 positions apart
        for (int i = 0; i <= nums.length - k; i++) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }
        
        return minDiff;
    }
}