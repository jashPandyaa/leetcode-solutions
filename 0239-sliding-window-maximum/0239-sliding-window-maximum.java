import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //edge cases
        if( nums == null || nums.length == 0 || k <=0 ){
            return new int[0];
        }

        int n = nums.length;
        int [] result = new int[n - k + 1];
        Deque<Integer> deque  = new LinkedList<>();

        for(int i=0; i<n; i++){
            //remove indices those are out of current window
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }

            //remove indices whose corresponding values are less than nums[i]
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
        
            //add the current index to the deque
            deque.offer(i);

            //add the maximum element of the current window to the result array
            if( i >= k - 1){
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }
}