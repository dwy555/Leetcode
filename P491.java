// No.491. Increasing Subsequences
class Solution {
    List<List<Integer>> ans = new LinkedList<>();
        
    public List<List<Integer>> findSubsequences(int[] nums) {
        addToList(nums,0,new LinkedList<Integer>());
        return ans;
    }
    
    private void addToList(int[] nums, int index, LinkedList<Integer> list){
        if(list.size() > 1)ans.add(new LinkedList<Integer>(list));
        Set<Integer> set = new HashSet<>();
        for(int i = index; i < nums.length; i++){
            if(set.contains(nums[i]))continue;
            if(list.size() == 0 || nums[i] >= list.peekLast()){
                set.add(nums[i]);
                list.add(nums[i]);
                addToList(nums, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
