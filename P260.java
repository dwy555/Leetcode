// No.260 Single Number III
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(Integer num: nums){
            xor ^= num;
        }
        int bit = xor & ~(xor-1);
        int num1=0,num2=0;
        for(Integer num: nums){
            if((bit&num) > 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        return new int[]{num1,num2};
    }
}
