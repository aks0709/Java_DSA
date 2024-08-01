package DyanamicProgramming.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class UnboundedKnapsack {

    class Solution{
        static int knapSack(int N, int W, int val[], int wt[])
        {
            // code here
            int dp[][]=new int[N][W+1];
            for(int rows[]: dp)
                Arrays.fill(rows,-1);

            return helper(N-1,W,wt,val,dp);
        }
        static int helper(int index,int maxW,int wt[],int val[],int dp[][]){
            //base case
            if(index==0){
                return (val[0])*((int)(maxW/wt[0]));
            }

            if(dp[index][maxW]!=-1) return dp[index][maxW];
            //pick it or not pick it
            //not pick

            int notPick=helper(index-1,maxW,wt,val,dp);
            //pick
            int pick=Integer.MIN_VALUE;
            if(wt[index]<=maxW)
                pick=val[index]+helper(index,maxW-wt[index],wt,val,dp);

            return dp[index][maxW]=Math.max(pick,notPick);
        }
    }
}
