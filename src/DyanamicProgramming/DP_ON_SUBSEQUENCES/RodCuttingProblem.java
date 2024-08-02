package DyanamicProgramming.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {

    }
    class Solution{
        public int cutRod(int price[], int n) {
            //code here
            int dp[][]=new int[n][n+1];
            for(int rows[] :dp){
                Arrays.fill(rows,-1);
            }
            return helper(n-1,n,price,dp);
        }
        public int helper(int index,int N,int price[],int dp[][]){
            if(index==0){
                return N*price[0];
            }
            if(dp[index][N]!=-1) return dp[index][N];
            int notPick=helper(index-1,N,price,dp);
            int pick=Integer.MIN_VALUE;
            int rodLength=index+1;
            if(rodLength<=N)
                pick=price[index]+helper(index,N-rodLength,price,dp);

            return dp[index][N]=Math.max(pick,notPick);
        }
    }
}
