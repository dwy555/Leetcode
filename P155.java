// No.155 Min Stack
class MinStack {

    /** initialize your data structure here. */
    class Cell{
        int value;
        int min;
        Cell(int v, int m){
            value = v;
            min = m;
        }
    }
    List<Cell> stack;
    public MinStack() {
        stack = new LinkedList<Cell>();
    }
    
    public void push(int x) {
        int min = getMin();
        stack.add(new Cell(x, Math.min(x, min)));
    }
    
    public void pop() {
        if(!isEmpty())
            stack.remove(stack.size()-1);
    }
    
    public int top() {
        //if(isEmpty())return new Integer();
        return stack.get(stack.size()-1).value;
    }
    
    public int getMin() {
        if(isEmpty())return Integer.MAX_VALUE;
        return stack.get(stack.size()-1).min;
    }
    
    public boolean isEmpty(){
        return stack.size()==0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
