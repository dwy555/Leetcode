// No.91 Decode Ways
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i <= len; i++){
            
            int w1 = s.charAt(i-1) == '0'?0:dp[i-1];
            int num = 10*(s.charAt(i-2)-'0')+(s.charAt(i-1)-'0');
            int w2 = (num<=26 && num >= 10)?dp[i-2]:0;
            dp[i] = w1 + w2;
            
        }
        return dp[len];
    }
}
