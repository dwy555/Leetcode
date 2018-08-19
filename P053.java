// No.53. Maximum Subarray
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = nums[0] < 0?0:nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(nums[i] + pre,sum);
            pre = Math.max(nums[i] + pre,0);
        }
        return sum;
    }
}
