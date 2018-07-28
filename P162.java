// No.162 Find Peak Element
class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int l = 0, h = len -1;
        while(l < h){
            int mid = (l+h)/2;
            if(nums[mid] > nums[mid+1])
                h = mid;
            else
                l = mid+1;
        }
        return l;
    }
}
