package DyanamicProgramming.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int dp[][]=new int [coins.length][amount+1];
            for(int rows []: dp){
                Arrays.fill(rows,-1);
            }
            int result = helper(coins.length - 1, amount, coins, dp);
            return result >= (int) Math.pow(10, 9) ? -1 : result;

        }
        public static int helper(int index,int amount,int coins[],int dp[][]){
            if(index==0){
                if (amount % coins[0] == 0) return amount / coins[0];
                else   return (int) Math.pow(10, 9);
                // If not, return a large value to indicate it's not possible
            }

            if(dp[index][amount]!=-1) return dp[index][amount];
            int notPick=0+helper(index-1,amount,coins,dp);
            int pick = (int) Math.pow(10, 9);
            if(coins[index]<=amount)
                pick=1+helper(index,amount-coins[index],coins,dp);

            return dp[index][amount]=Math.min(pick,notPick);
        }
    }
}
