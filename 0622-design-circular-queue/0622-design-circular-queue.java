class MyCircularQueue {
    private final int[] data;
    private final int cap; //Capacity of queue
    private int head; //Starting pointer
    private int size; //Total size

    //Constructor
    public MyCircularQueue(int k) {
        data = new int[k];
        cap = k;
        head = 0;
        size = 0;
    }
    
    //Insert at rear
    public boolean enQueue(int value) {
        if(isFull()) return false;
        int tail = (head + size) % cap;
        data[tail] = value;
        size++;
        return true;
    }
    
    //Remove from front
    public boolean deQueue() {
        if(isEmpty()) return false;
        head = (head + 1) % cap;
        size--;
        return true;
    }
    
    //Get front element
    public int Front() {
        return isEmpty() ? -1 : data[head];
    }
    
    //Get rear element
    public int Rear() {
        if(isEmpty()) return -1;
        int tail = (head + size - 1) % cap;
        return data[tail];
    }
    
    //Check empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    //Check size
    public boolean isFull() {
        return size == cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */