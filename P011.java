// No.11. Container With Most Water
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int max = 0, area;
        while(left < right){
            if(height[left] < height[right]){
                area = (right-left)*height[left];
                left++;
            }else{
                area = (right-left)*height[right];
                right--;
            }
            max = Math.max(max,area);
        }
        
        return max;
    }
}
