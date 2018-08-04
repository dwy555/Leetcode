// No.283 Move Zeroes
class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        
        for(Integer num: nums)
            if(num != 0)
                nums[pos++] = num;
        
        while(pos < nums.length)
            nums[pos++] = 0;
    }
}
