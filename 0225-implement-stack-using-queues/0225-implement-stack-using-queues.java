import java.util.*;

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();    
        q2 = new LinkedList<>();
    }
    
    //Push elements x onto stack
    public void push(int x) {
        //step 1 : add to q2
        q2.offer(x);

        //step 2 : move everything from q1 to q2
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }

        //Step 3: swap q1 and q2
        Queue<Integer> temp  = q1;
        q1 = q2;
        q2 = temp;   
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */