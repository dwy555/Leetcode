 // No. 349. Intersection of Two Arrays
 class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(Integer num: nums1)
            set.add(num);
        for(Integer num: nums2){
            if(set.contains(num))
                res.add(num);
        }
        int[] ans = new int[res.size()];
        int i = 0;
        for(Integer num: res){
            ans[i++] = num;
        }
        return ans;
    }
}
