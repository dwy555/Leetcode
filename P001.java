// No.1 Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;
        for(int i = 0; i < len; i ++){
            if(map == null){
                map.put(nums[i], i);
            }else{
                if(map.containsKey(target - nums[i])){
                    return new int[]{map.get(target - nums[i]), i};
                }else{
                    map.put(nums[i], i);
                }
            }
            
        }
        return null;
    }
}
