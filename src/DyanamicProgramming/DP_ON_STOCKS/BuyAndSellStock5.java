package DyanamicProgramming.DP_ON_STOCKS;

import java.util.Arrays;

public class BuyAndSellStock5 {
    class Solution {
        public int maxProfit(int[] prices) {
            int dp[][]=new int[prices.length][2];
            for(int rows[] : dp)
                Arrays.fill(rows,-1);

            return helper(0,1,prices,dp);
        }
        public static int helper(int index,int buy,int prices[],int dp[][]){
            //base case
            if(index>=prices.length)  //>= to handle edge case
                return 0;

            if(dp[index][buy]!=-1) return dp[index][buy];
            //possiblites
            int profit;
            if(buy==1){
                profit=Math.max(-prices[index]+helper(index+1,0,prices,dp),0+helper(index+1,1,prices,dp));
            }
            else{
                profit=Math.max(prices[index]+helper(index+2,1,prices,dp),0+helper(index+1,0,prices,dp));
            }

            return dp[index][buy]=profit;
        }
    }
}
