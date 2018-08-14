// No.622. Design Circular Queue
class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    private int[] queue;
    private int size;
    private int head;
    private int tail;
    private int k;
    public MyCircularQueue(int k) {
        queue = new int[k];
        size = 0;
        head = 0;
        tail = -1;
        this.k = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull())return false;
        tail = (tail + 1)%k;
        queue[tail] = value;
        size++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())return false;
        head = (head+1)%k;
        size--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())return -1;
        return queue[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())return -1;
        return queue[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == k;
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
