class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int lcs = 1;    // Current sequence length
        int maxLcs = 1;     // Maximum sequence length found so far

        Arrays.sort(nums);

        for(int i=0; i<nums.length-1; i++){
            int j = i+1;

            //skip duplicates
            if(nums[i] == nums[j]){
                continue;
            }

            if(nums[j] - nums[i] == 1){
                lcs++;
                maxLcs = Math.max(maxLcs, lcs);
            }else{
                // Sequence breaks - reset lcs
                lcs = 1;
            }
            
        }

        return maxLcs;
    }
}