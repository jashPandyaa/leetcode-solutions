import java.util.*;

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;

        long total = 0;     //Sum of all absolute value
        int negativeCount = 0;      //Count all negative numbers in whole matrix
        int minAbsValue = Integer.MAX_VALUE;    //smallest absolute value
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                int val = matrix[i][j];
                total += Math.abs(val);

                if(val < 0){
                    negativeCount++;
                }

                minAbsValue = Math.min(minAbsValue, Math.abs(val));
            }   
        }
        //if even negatives : all can be positive
        if(negativeCount % 2 == 0){
            return total;   
        }

        //if odd negatives : one must stay negative (choose smallest)
        return total - 2 * minAbsValue; //Case 2: 18  - 2 * 1 = 16
    }
}