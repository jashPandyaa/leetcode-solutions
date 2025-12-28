import java.util.Stack;
class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> removeIndices = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                stack.push(i);
            }else if(c == ')'){
                if(stack.isEmpty()){
                    //Add the index of position of invalid parentheses to the HashSet
                    removeIndices.add(i);
                }else{
                    //Else it is valid than pop the element
                    stack.pop();
                }
            }
        }

        //Add remaining unmatched opening parentheses indices to the set
        while(!stack.isEmpty()){
            removeIndices.add(stack.pop());
        }

        //Build the result string
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!removeIndices.contains(i)){
                result.append(s.charAt(i));
            }
        }
 
        return result.toString();
    }
}