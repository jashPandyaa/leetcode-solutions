import java.util.*;

class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        for(int i = 0; i < n - 1; i++){
            if(nums[i] == nums[i + 1]){
                return nums[i];
            }
        }

        return 0;
    }
}