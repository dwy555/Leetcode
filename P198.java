// No.198. House Robber
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0)return 0;
        int pre = 0, pro = nums[0];
        for(int i = 1; i < n; i++){
            int tem = pro;
            pro = Math.max(pro,pre+nums[i]);
            pre = tem;
        }
        return pro;
    }
}
