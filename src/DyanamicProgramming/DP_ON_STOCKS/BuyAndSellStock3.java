package DyanamicProgramming.DP_ON_STOCKS;

import java.util.Arrays;

public class BuyAndSellStock3 {
    class Solution {
        public int maxProfit(int[] prices) {
            int n=prices.length;
            int[][][] dp = new int[n][2][3];

            // Initialize the dp array with -1
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }

            return helper(0,1,2,prices,dp);
        }
        public static int helper(int index,int buy,int count,int prices[],int dp[][][]){
            //base case
            if(index==prices.length) return 0;

            if(count==0) return 0;


            if (dp[index][buy][count] != -1)
                return dp[index][buy][count];

            //possiblities
            int profit;
            if(buy==1){
                profit=Math.max(-prices[index]+helper(index+1,0,count,prices,dp),0+helper(index+1,1,count,prices,dp));
            }
            else{
                profit=Math.max(prices[index]+helper(index+1,1,count-1,prices,dp),0+helper(index+1,0,count,prices,dp));
            }
            return dp[index][buy][count]=profit;

        }
    }
}
