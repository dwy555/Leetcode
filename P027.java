// No.27 Remove Element
class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int pre = 0, rear = len -1;
        while(pre <= rear){
            if(nums[pre] != val){
                pre++;
                continue;
            }
            while(rear >= pre && nums[rear] == val )rear--;
            if(rear < pre)return pre;
            int tem = nums[pre];
            nums[pre] = nums[rear];
            nums[rear] = nums[pre];
            pre++;rear--;
        }
        return pre;
    }
}
