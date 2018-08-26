// No.123. Best Time to Buy and Sell Stock III
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] left = new int[len];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < len; i++){
            max = Math.max(max,prices[i]-min);
            min = Math.min(min, prices[i]);
            left[i] = max;
        }
        max = 0;
        int right = 0;
        int ans = 0;
        for(int i = len - 1; i >= 0; i--){
            right = Math.max(right,max-prices[i]);
            max = Math.max(max, prices[i]);
            ans = Math.max(ans, right+left[i]);
        }
        return ans;
    }
}
