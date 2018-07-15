// No.326 Power of Three
class Solution {
    public boolean isPowerOfThree(int n) {
        // if(n <= 0)return false;
        // int maxPow = (int)Math.pow(3, (int)(Math.log(0x7fffffff)/Math.log(3)));
        // return (maxPow%n == 0);
        if(n <= 0)return false;
        while(n != 1){
            if(n % 3 != 0)return false;
            n = n/3;
        }
        return true;
    }
}
