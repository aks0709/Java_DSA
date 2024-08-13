package DyanamicProgramming.DP_ON_STOCKS;

public class BuyAndSellStocks1 {
    class Solution {
        public int maxProfit(int[] prices) {
            int mini=prices[0];
            int profit=0;
            for(int i=1;i<prices.length;i++){
                int cost=prices[i]-mini;
                profit=Math.max(profit,cost);
                mini=Math.min(mini,prices[i]);   //this is the reason it comes under DP ,as it is storing and memorizing previously evaluted minimum
            }
            return profit;
        }
    }
}
