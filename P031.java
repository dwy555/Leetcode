// No.31 Next Permutation
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int temp,i;
        
        for(i = len-1; i > 0; i--)
            if(nums[i] > nums[i-1])
                break;
        
        if(i > 0){
            int index = i;
            for(int j = i; j < len; j++){
                if(nums[j] > nums[i-1] && nums[j] <= nums[index])index = j;
            }
            temp = nums[index];
            nums[index] = nums[i-1];
            nums[i-1] = temp;
        }
        
        for(int m = i, n = len -1; m < n; m++, n-- ){
            temp = nums[n];
            nums[n] = nums[m];
            nums[m] = temp;
        }   
        
    }
}
