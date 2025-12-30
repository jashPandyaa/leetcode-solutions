import java.util.*;
class MyQueue {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }
    
    // Enque - O(1)
    public void push(int x) {
        inStack.push(x);
    }
    
    //Deque - O(n)
    public int pop() {
        moveIfNeeded();
        return outStack.pop();
    }
    
    // Peek front - O(n)
    public int peek() {
        moveIfNeeded();
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty(); 
    }

    //Helper method : Move elements only when outStack is empty
    public void moveIfNeeded(){
        if(outStack.isEmpty()){
            //Transfer elements from inStack to outStack untill instack becomes empty
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */