package DyanamicProgramming.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class Knapsack01Problem {
    public static void main(String[] args) {

    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][]=new int[n][maxWeight+1];
        for(int rows[] : dp)
            Arrays.fill(rows, -1);

        return helper(n-1, maxWeight, weight, value, dp);

    }
    public static int helper(int index,int W,int weight[],int value[],int dp[][]){
        if(index==0){
            if(weight[index]<=W) return value[index];
            else return 0;
        }

        if( dp[index][W]!=-1 ) return dp[index][W];

        int notPick=0+helper(index-1, W, weight, value, dp);
        int pick=Integer.MIN_VALUE;
        if(weight[index]<=W)
            pick=value[index]+helper(index-1, W-weight[index], weight, value, dp);

        return dp[index][W]=Math.max(notPick, pick);
    }
    //tabulation
    public static int helper2(int n, int W, int weight[], int value[]) {
        int dp[][] = new int[n][W + 1];

        for(int w=weight[0];w<=W;w++)
            dp[0][w]=value[0];

        // Fill the dp array for subsequent items
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                // Not pick the current item
                int notPick = dp[i - 1][j];

                // Pick the current item (if it fits)
                int pick = Integer.MIN_VALUE;
                if (weight[i] <= j) {
                    pick = value[i] + dp[i - 1][j - weight[i]];
                }

                // Store the result in dp table
                dp[i][j] = Math.max(notPick, pick);
            }
        }

        return dp[n - 1][W];
    }
}
