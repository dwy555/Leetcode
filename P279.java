// No.279. Perfect Squares
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++ ){
            int sqrt = (int)Math.sqrt(i);
            if(sqrt*sqrt == i)dp[i] = 1;
            for(int j = 1; j <= sqrt; j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
