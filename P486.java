// No.486 Predict the Winner
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        return max(0, n-1, nums, 1) >= 0;
    }
    
    public int max(int start, int end, int[] nums, int player){
        if(start == end){
            return player * nums[start];
        } 
        int s1 = nums[start]*player + max(start +1, end, nums, -player);
        int s2 = nums[end]*player + max(start, end-1, nums, -player);
        return player*Math.max(s1*player, s2*player);
    }
}
