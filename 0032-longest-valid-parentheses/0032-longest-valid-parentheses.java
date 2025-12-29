import java.util.*;
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        stack.push(-1); //Base for next valid substring

        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                //Push the index of '(' into the Stack
                stack.push(i);
            }else{
                //Pop the top of the stack index
                stack.pop();

                if(stack.isEmpty()){
                    //If the stack is empty , push the current index as the base for the next valid SubString
                    stack.push(i);
                }else{
                    //Calculate the length of current valid subString
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}