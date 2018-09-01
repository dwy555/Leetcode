// No.123. Best Time to Buy and Sell Stock III
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1)return 0;
        int[] left = new int[len];
        left[0] = 0;
        int min = prices[0], max = prices[len-1];
        int ans = 0;
        for(int i = 1; i < len; i++){
            left[i] = Math.max(left[i-1],prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        int right = 0;
        for(int i = len - 2; i >= 0; i--){
            right = Math.max(right, max-prices[i]);
            max = Math.max(max, prices[i]);
            ans = Math.max(ans, left[i]+right);
        }
        return ans;
    }
}
