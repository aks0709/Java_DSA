package DyanamicProgramming.DP_ON_GRIDS;

import java.util.Arrays;

public class MinPathSum {
    class Solution {
        public int minPathSum(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            int dp[][]=new int[m][n];
            for(int rows[] : dp){
                Arrays.fill(rows,-1);
            }
            return minPath(m-1,n-1,grid,dp);
            //return helper(m,n,grid,dp); //tabulation
        }
        public static int minPath(int i,int j,int [][] grid,int dp[][]){
            //base case
            if(i==0&&j==0)  return grid[0][0];
            //when we go out of boundary we need to return such value such that the path is not taken into the consideration,since we are finding Min Path,so we retuen Large VALUE on invalid path
            //DO NOT RETURN INTEGER.MAX_VALUE AS IT RESULTS IN ERROR
            if(i < 0 || j < 0)
                return (int) Math.pow(10, 9);

            if(dp[i][j]!=-1) return dp[i][j];
            int up=grid[i][j]+minPath(i-1,j,grid,dp);
            int left=grid[i][j]+minPath(i,j-1,grid,dp);

            return dp[i][j]=Math.min(up,left);


        }

        public static int helper(int m, int n, int grid[][], int dp[][]) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = grid[i][j];
                    } else {
                        int up = grid[i][j];
                        int left = grid[i][j];

                        if (i > 0) up = up + dp[i - 1][j];
                        else up += (int) Math.pow(10, 9);
                        if (j > 0) left = left + dp[i][j - 1];
                        else left += (int) Math.pow(10, 9);

                        dp[i][j] = Math.min(up, left);
                    }
                }
            }
            return dp[m - 1][n - 1];
        }

    }
}
