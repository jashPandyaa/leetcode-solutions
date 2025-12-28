class Solution {
    //In brute force , Time Comp : O(n^2)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int []answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i < n ; i++){
            //Do if only temp is greater than the last pushed element and stack is not empty
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                answer[index] = i - index;
            }
            //Push the index of current element
            stack.push(i);
        }
        return answer;
    }
}