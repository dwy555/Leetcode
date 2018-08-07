// No.540 Single Element in a Sorted Array
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right)/2;
            if(mid + 1 < nums.length && nums[mid] == nums[mid+1]){
                if((mid - left)%2 != 0)right = mid - 1;
                else left = mid + 2;
            }else if( mid - 1 >= 0 && nums[mid] == nums[mid-1]){
                if((right - mid)%2 != 0)left = mid + 1;
                else right = mid - 2;
            }else{
                return nums[mid];
            }
        }
        return nums[left];
    }
}
