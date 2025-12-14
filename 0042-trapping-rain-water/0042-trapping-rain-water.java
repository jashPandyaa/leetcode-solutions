class Solution {
    public int trap(int[] height) {
        // int n = height.length;
        // //leftmax bound
        // int lb[] = new int[n];
        // lb[0] = height[0];
        // for(int i=1; i<n ; i++){
        //     lb[i] = Math.max( height[i] , lb[i-1]); 
        // }
        // //rightmax bound
        // int rb[] = new int[n];
        // rb[n-1] = height[n-1];
        // for(int i=n-2; i>=0; i--){
        //     rb[i] = Math.max( height[i] , rb[i+1]);
        // }

        // int tpw = 0;
        // //loop
        // for(int i = 0; i<n; i++){
        //     int waterlevel = Math.min( lb[i] , rb[i]);

        //     tpw += waterlevel - height[i];
        // }
        // return tpw;
        int left = 1;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int sum = 0;
        while(left <= right){
            if(leftMax <= rightMax){
                leftMax = Math.max(height[left],leftMax);
                sum += leftMax - height[left];
                left++;
            }else{
                rightMax = Math.max(height[right], rightMax);
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }
}