package DyanamicProgramming.DP_ON_STOCKS;

import java.util.Arrays;

public class BuyAndSellStock2 {
    class Solution {
        public int maxProfit(int[] prices) {
            int dp[][]=new int[prices.length][2];
            for(int rows[] :dp)
                Arrays.fill(rows,-1);

            return helper(0,1,dp,prices);
        }
        public static int helper(int index,int buy,int dp[][],int prices[]){
            if(index==prices.length) return 0;
            int profit;
            if(dp[index][buy]!=-1) return dp[index][buy];
            if(buy==1){
                //buy vs dont buy
                profit= Math.max(-prices[index] + helper(index+1,0,dp,prices),0+helper(index+1,1,dp,prices));
            }
            else{
                //sellvs notsell
                profit= Math.max(prices[index] + helper(index+1,1,dp,prices),0+helper(index+1,0,dp,prices));
            }

            return dp[index][buy]=profit;
        }
    }
}
