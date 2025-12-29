import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        for(int i = 0; i <= n ; i++){
            //Calculate current height for each element untill last element
            int currHeight = (i == n) ? 0 : heights[i];
            //Calculate only if current height is higher than the element the present inside Stack
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
                //Do the calculate maxArea accordingly height and width 
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea , height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}