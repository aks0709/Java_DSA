package DyanamicProgramming.DP_ON_GRIDS;

import java.util.Arrays;

public class Min_Max_Path_Variable_startANDdestination {
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n=matrix.length;
            int dp[][]=new int[n][n];
            for(int []rows : dp){
                Arrays.fill(rows,-1);
            }
            int mini= Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                int res=helper(n-1,j,matrix,dp);
                mini=Math.min(res,mini);
            }
            return mini;
        }

        public int helper(int i,int j,int [][]grid,int [][]dp){
            if(j<0  || j > grid.length-1) return (int) 1e9;
            if(i==0)  return grid[i][j];

            if(dp[i][j]!=-1)  return dp[i][j];
            //movements
            int up=grid[i][j]+helper(i-1,j,grid,dp);
            int leftDiag=grid[i][j]+helper(i-1,j-1,grid,dp);
            int rightDiag=grid[i][j]+helper(i-1,j+1,grid,dp);

            return dp[i][j]=Math.min(up,Math.min(leftDiag,rightDiag));
        }
    }
}
