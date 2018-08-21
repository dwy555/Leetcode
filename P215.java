// No.215. Kth Largest Element in an Array
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue();
        for(Integer num: nums){
            q.add(num);
            if(q.size() > k)
                q.poll();
        }
        return q.peek();
    }
}
