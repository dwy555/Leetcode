// No.Regular Expression Matching
class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for(int i = 1; i <= pLen; i++){
            if(p.charAt(i-1) == '*')
                dp[0][i] = dp[0][i-2];
        }
        for(int i = 0; i < sLen; i ++){
            for(int j = 0; j < pLen; j++){
                if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))
                    dp[i+1][j+1] = dp[i][j];
                else if(p.charAt(j) == '*'){
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.')
                        dp[i+1][j+1] = dp[i+1][j-1];
                    else
                        dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1];
                }
                else dp[i+1][j+1] = false;
            }
        }
        return dp[sLen][pLen];
        
    }
}
