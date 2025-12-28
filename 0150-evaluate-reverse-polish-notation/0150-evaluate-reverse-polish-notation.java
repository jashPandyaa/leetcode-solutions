import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
          Stack<Integer> stack = new Stack<>();

          for(String token : tokens){
            //If operator is found do calculation accordingly token of operator
            if(isOperator(token)){
                int b = stack.pop();
                int a = stack.pop();

                int result = applyOperator(token, a, b);
                //Push that new resultnt element into the stack
                stack.push(result);
            }else{
                //Parsing of String's single character into Integer (e.g '2') 
                stack.push(Integer.parseInt(token));
            }
          }

          return stack.pop();
    }
    //Return corresponding token accordingly we get in tokens[token]
    private boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    //Calculation part
    private int applyOperator(String operator, int a, int b){
        switch(operator){
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            case "/" : return a / b;
            default : throw new IllegalArgumentException("Invalid input");
        }
    }
}