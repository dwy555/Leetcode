// No.219 Contains Duplicate II
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer pre = map.put(nums[i],i);
            if(pre != null && i - pre <= k)return true;        
        }
        return false;
    }
}
