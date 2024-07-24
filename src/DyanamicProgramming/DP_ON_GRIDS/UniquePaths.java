package DyanamicProgramming.DP_ON_GRIDS;

import java.util.Arrays;

public class UniquePaths {
    class Solution {
        public int uniquePaths(int m, int n) {
            int dp[][]=new int[m][n];
            for(int rows[] : dp){
                Arrays.fill(rows,-1);
            }
            return helper(m-1,n-1,dp);
        }

        public static int helper(int i,int j,int dp[][]){
            //base case
            if(i==0&&j==0) return 1;
            if(i<0||j<0)  return 0;

            if(dp[i][j]!=-1) return dp[i][j];
            int up=helper(i-1,j,dp);
            int left=helper(i,j-1,dp);

            return dp[i][j]=up+left;
        }
        //tabulation
        public static int helper2(int m,int n,int dp[][]){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i==0&&j==0)  dp[i][j]=1;
                    else{
                        int up=0,left=0;
                        if(i>0) up=dp[i-1][j];
                        if(j>0)  left=dp[i][j-1];

                        dp[i][j]=up+left;
                    }
                }
            }
            return dp[m-1][n-1];
        }

    }
}
