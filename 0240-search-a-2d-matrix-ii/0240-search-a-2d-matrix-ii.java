class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Brute Force
        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         if( matrix[i][j] == target ){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        //Optimal : 2 pointer approach using Left and right pointer
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;

        while(left < m && right >= 0){
            if(matrix[left][right] == target){
                return true;
            }else if(matrix[left][right] > target){
                right--;
            }else{
                left++;
            }
        }

        return false;
    }
}