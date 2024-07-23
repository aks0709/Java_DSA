package DyanamicProgramming.DP_ON_GRIDS;

import java.util.Arrays;

public class UniquePathWithObstacle {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m=obstacleGrid.length;
            int n=obstacleGrid[0].length;
            int dp[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
            for(int rows[] : dp){
                Arrays.fill(rows,-1);
            }
            return helper(m-1,n-1,dp,obstacleGrid);
        }
        public static int helper(int i,int j,int dp[][],int[][] Grid){
            if(i==0&&j==0&&Grid[i][j]!=1) return 1;

            if(i<0||j<0) return 0;
            //base case for obstacles
            if(Grid[i][j]==1) return 0;

            if(dp[i][j]!=-1) return dp[i][j];
            int up=helper(i-1,j,dp,Grid);
            int left=helper(i,j-1,dp,Grid);

            return dp[i][j]=up+left;
        }
    }
}
