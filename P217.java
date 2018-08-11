// No.217. Contains Duplicate
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer num: nums){
            if(map.put(num,1) != null)return true;
        }
        return false;
    }
}
