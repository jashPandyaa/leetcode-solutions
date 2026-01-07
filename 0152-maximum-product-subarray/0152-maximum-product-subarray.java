import java.util.*;

class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0]; // Max product ending at current position
        int currMin = nums[0];  // Min product ending at current position (for negatives)
        int maxProduct = nums[0];

        for(int i = 1; i < nums.length ; i++){
            int num = nums[i];

            //when multiplying by negative max becomes min , Vice Verse
            if( num < 0){
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            // Either extend existing product or start fresh
            currMax = Math.max(num, currMax * num);
            currMin = Math.min(num, currMin * num);

            maxProduct = Math.max(currMax, maxProduct);
        }
        return maxProduct;
    }
}
