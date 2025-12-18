import java.util.*;
class Solution {
    public int findMin(int[] nums) {
        //Brute Force Approach : O(n)
        int maxMin = Integer.MAX_VALUE;

        for(int i=0; i < nums.length; i++){
            if(nums[i] < maxMin){
                maxMin = nums[i];
            }
        }

        return maxMin;
    }
}