class Solution {
    public int removeDuplicates(int[] nums) {
        //edge case
        if (nums.length == 0) return 0;

        //two pointers + sliding window ( i to j ) 
        int i = 1;
        
        for (int j = 1; j < nums.length; j++) {
            //we skip to the next index if we see a duplicate element
            if (nums[j] != nums[j - 1]) {
                //storing the unique element at ith index and incrementing to check for further for same elements
                nums[i] = nums[j];
                i++;
            }
        }

        return i;        
    }
}