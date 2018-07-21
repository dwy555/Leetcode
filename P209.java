// No.209 Minimum Size Subarray Sum
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int l = 0;
        for(int r = 0; r < n; r++){
            sum += nums[r];
            while (sum >= s){
                res = Math.min(res, r-l+1);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
