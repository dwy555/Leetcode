// No.456 132 Pattern
class Solution {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        
        for(int n: nums){
            if(min.isEmpty() || n <min.peek() ){
                min.push(n);
                max.push(n);
            } 
            else if(n > min.peek()){ 
                if(n < max.pop()) return true;
                else {
                    int cur = min.pop();
                    while(!max.isEmpty() && n >= max.peek()){
                        min.pop();
                        max.pop();
                    }
                    if(!min.isEmpty() && min.peek() < n) return true;
                    min.push(cur);
                    max.push(n);
                    
                }
                
            }
        }
        return false;
    }
}
