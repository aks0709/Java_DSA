package DyanamicProgramming.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class CoinChange2 {
    class Solution {
        public int change(int amount, int[] coins) {
            int dp[][]=new int[coins.length][amount+1];
            for(int rows[] : dp)
                Arrays.fill(rows,-1);

            return helper(coins.length-1,amount,coins,dp);
        }
        public int helper(int index,int amount,int coins[],int dp[][]){
            //base case
            if(index==0)
            {
                return (amount % coins[0] == 0) ? 1 : 0;
            }

            if(dp[index][amount]!=-1) return dp[index][amount];

            //not pick
            int notpick=helper(index-1,amount,coins,dp);
            int pick=0;
            if(coins[index]<=amount)
                pick=helper(index,amount-coins[index],coins,dp);

            return dp[index][amount]=pick+notpick;

        }
    }
}
