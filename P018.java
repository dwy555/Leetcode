// No.18. 4Sum
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target)continue;
            if(nums[i] + nums[len-3] + nums[len-2] + nums[len-1] < target)continue;
            for(int j = i+1; j < nums.length - 2; j++){
                if(j > i+1 && nums[j] == nums[j-1])continue;
                if(nums[i] + nums[j] + nums[j+1] + nums[j+2] > target)continue;
                if(nums[i] + nums[j] + nums[len-2] + nums[len-1] < target)continue; 
                int l = j +1, r = nums.length - 1;
                while(l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;r--;
                        while(l < r && nums[l] == nums[l-1])l++;
                        while(l < r && nums[r] == nums[r+1])r--;
                    }else if(sum < target)l++;
                    else r--;
                    
                }
            }
        }
        return ans;
    }
}
