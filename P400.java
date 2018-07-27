// No.400 Nth Digit
class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        long base = 1;
        while(n > digit*base*9){
            n -= digit*base*9;
            digit ++;
            base *= 10;
        }
        int add = (int)Math.ceil((double)n/digit);
        int num = (int)base-1 + (int)Math.ceil((double)n/digit);
        int rest = n - (add-1)*digit;
        int start = 1;
        while(start < rest){
            num %= base;
            base /= 10;
            start ++;
        }
        return num/(int)base;
    }
}
