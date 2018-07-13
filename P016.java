// No.16 3Sum Closest
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int res = nums[0]+nums[1]+nums[len-1];
        Arrays.sort(nums);
        for(int i = 0; i < len-2; i ++){
            int start = i+1, end = len-1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > target){
                    end--;
                }else if(sum < target){
                    start ++;
                }else{
                    return target;
                }
                if(Math.abs(res - target) > Math.abs(sum - target))
                    res = sum;
            }
        }
        return res;
    }
}
