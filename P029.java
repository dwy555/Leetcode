// No.29. Divide Two Integers
class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0)return -1;
        if(dividend == 0)return 0;
        long dd = Math.abs((long)dividend), ds = Math.abs((long)divisor);
        long ans = 0, curr = 1;
        long sub = ds;
        
        while (dd >= ds) {
            if (dd >= sub) {
                ans += curr;
                dd -= sub;
                sub = sub << 1; //sub = sub * 2
                curr = curr << 1; //curr = curr * 2
            }
            else {
                sub = sub >> 1;
                curr = curr >> 1;
            }
        }
        
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)ans = -ans;
        return ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE?Integer.MAX_VALUE:(int)ans;
    }
}
