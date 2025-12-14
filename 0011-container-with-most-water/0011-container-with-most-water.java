import java.util.*;
class Solution {
    public int maxArea(int[] height) {
    //take two pointers left and right to reduce the time complexity
    int left = 0 , right = height.length - 1;
    int maxWater = 0;   // our answer

    while( left != right){
        int hi = Math.min(height[left] , height[right]);
        int wi = right - left;
        int area = hi * wi;
        
        //Update the maximum area of a container with most water if it does!
        maxWater = Math.max(area, maxWater);

        //Update the pointers based on their minimum height
        if( height[left] < height[right]){
            left++;
        }else{
            right--;
        }
    }

    return maxWater;
    }
}