// No.15 3Sum
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i ++){
            if(i > 0 && nums[i] == nums[i-1])continue;
            int l = i+1, h = nums.length-1;
            while(l < h){
                if(nums[i] + nums[l] + nums[h] == 0){
                    list.add(Arrays.asList(nums[i],nums[l],nums[h]));
                    l++; h--;
                    while(l < h && nums[l] == nums[l-1])l++;
                    while(h > l && nums[h] == nums[h+1])h--;
                }else if(nums[i] + nums[l] + nums[h] > 0)h--;
                else l++;
            }
        }
        return list;
        
    }
}
