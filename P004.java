// No.4 Median of Two Sorted Arrays
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int mid1 = (len1 + len2 + 2)/2, mid2 = (len1 + len2 + 1)/2;
        return (get(nums1, len1, 0, nums2, len2, 0, mid1) + get(nums1, len1, 0, nums2, len2, 0, mid2))/2;
    }
    
    public double get(int[] nums1, int m, int s1, int[] nums2, int n, int s2, int k){
        if(m == 0)return nums2[s2+k-1];
        if(n == 0)return nums1[s1+k-1];
        if(k == 1)return Math.min(nums1[s1], nums2[s2]);
        int i = Math.min(m, k/2), j = Math.min(n, k/2);
        if(nums1[s1+i-1] > nums2[s2+j-1])
            return get(nums1, m, s1, nums2, n - j, s2 + j, k - j);
        else
            return get(nums1, m - i, s1+i, nums2, n, s2, k - i);
    }
}
