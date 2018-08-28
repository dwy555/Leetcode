// No.15 3Sum
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1])continue;
            if(nums[i]+nums[i+1]+nums[i+2] > 0)continue;
            if(nums[i]+nums[nums.length-2]+nums[nums.length-1] < 0)continue;
            int left = i+1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;right--;
                    while(left < right && nums[left] == nums[left-1])left++;
                    while(left < right && nums[right] == nums[right+1])right--;
                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }
}
