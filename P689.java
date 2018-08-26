// No.689. Maximum Sum of 3 Non-Overlapping Subarrays
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int sum = 0;
        int len = nums.length;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        int[] sums = new int[len-k+1];
        sums[0] = sum;
        for(int i = 1; i < sums.length; i++){
            sum = sum - nums[i-1]+nums[i-1+k];
            sums[i] = sum;
        }
        int[] left = new int[len];
        int max = 0;
        for(int i = k; i < len; i++ ){
            if(sums[i-k] > sums[max]){
                max = i-k;
            }
            left[i] = max;
                
        }
        int[] right = new int[len];
        max = len-k;
        for(int i = len-k; i >=0; i--){
            if(sums[i] >= sums[max])
                max = i;
            right[i] = max;
        }
        int[] ans = new int[3]; 
        ans[0] = 0;ans[1] = k; ans[2] = 2*k;
        for(int i = k; i <= len - 2*k; i ++){
            if(sums[left[i]] + sums[i] + sums[right[i+k]] > sums[ans[0]]+sums[ans[1]]+sums[ans[2]]){
                ans[0] = left[i];
                ans[1] = i;
                ans[2] = right[i+k];
            }
        }
        return ans;
    }
}
