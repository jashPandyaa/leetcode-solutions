class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Brute Force: T.C : O(m * n) , S.C. : O(1)
        // for(int i=0; i < matrix.length; i++){
        //     for(int j=0; j < matrix[i].length; j++){
        //         if(matrix[i][j] == target)
        //             return true;
        //     }
        // }
        // return false;

        //Optimal approach: T.C = O(log(m * n))  , S.C = O(1)
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while(left <= right){
            int mid = (left + right)/2;
            int midValue = matrix[mid / n][mid % n];

            if(midValue == target){
                return true;
            }else if( midValue < target ){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return false;
    }
}