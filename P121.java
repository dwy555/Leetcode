// No.121. Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0)return 0;
        int ans = 0;
        int min = prices[0];
        for(int price: prices){
            ans = Math.max(ans, price - min);
            min = Math.min(min, price);
        }
        return ans;
    }
}
