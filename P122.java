//No.122. Best Time to Buy and Sell Stock II
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)return 0;
        int ans = 0;
        for(int i = 1; i < prices.length; i++){
            ans += Math.max(0, prices[i]-prices[i-1]);
        }
        return ans;
    }
}
