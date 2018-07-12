// No.232 Implement Queue using Stacks
class MyQueue {

    /** Initialize your data structure here. */
    
    Deque<Integer> queue;
    Deque<Integer> stack;
    public MyQueue() {
        queue = new LinkedList<Integer>();
        stack = new LinkedList<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!empty()){
            while(!empty()){
                stack.push(queue.pop());
            }
            int ans = stack.pop();
            while(!stack.isEmpty()){
                queue.push(stack.pop());
            }
            return ans;
        }
        return -1;
    }
    
    /** Get the front element. */
    public int peek() {
        if(!empty()){
            while(!empty()){
                stack.push(queue.pop());
            }
            int ans = stack.peek();
            while(!stack.isEmpty()){
                queue.push(stack.pop());
            }
            return ans;
        }
        return -1;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
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
