//No.88. Merge Sorted Array
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        m = m-1; n = n-1;
        while(n >= 0 || m >= 0){
            if(n < 0)break;
            if(m < 0 || nums1[m] < nums2[n])nums1[index--] = nums2[n--];
            else nums1[index--] = nums1[m--];
        }
    }
}
