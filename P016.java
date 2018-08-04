// No.16 3Sum Closest
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for(int i = 0; i < nums.length - 2; i ++){
            int start = i+1, end = nums.length -1;
            while(start < end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum == target)return target;
                if(Math.abs(ans-target) > Math.abs(sum-target)) ans = sum;
                if(sum < target) start++;
                else end--;
            }
        }
        return ans;
    }
}
