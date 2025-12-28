class MinStack {
    private Node head;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head == null){
            //If it is initialising first val then next pointer will be null
            head = new Node(val, val, null);
        }else{
            //Val as it is , for minimum compare current Val with all time minimum value
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next; 
    }
    
    public int top() {
        return head.val;
    }
    
    //This is the tricky one, except all can be done in O(1)
    public int getMin() {
        return head.min;
    }

    private class Node{
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */