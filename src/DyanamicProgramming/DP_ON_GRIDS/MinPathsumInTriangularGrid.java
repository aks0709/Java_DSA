package DyanamicProgramming.DP_ON_GRIDS;

import java.util.Arrays;
import java.util.List;

public class MinPathsumInTriangularGrid {

    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] grid = new int[n][n];
            int[][] dp = new int[n][n];

            // Initialize dp array with -1 (uncomputed values)
            for(int rows[] : dp){
                Arrays.fill(rows,-1);
            }

            // Copy triangle list to grid array
            for (int i = 0; i < n; i++) {
                List<Integer> row = triangle.get(i);
                for (int j = 0; j < row.size(); j++) {
                    grid[i][j] = row.get(j);
                }
            }

            return helper(0, 0, grid, dp);
            //return helper2(grid,dp,n);
        }

        public static int helper(int i, int j, int[][] grid, int[][] dp) {
            // Base case: last row
            if (i == grid.length - 1) return grid[i][j];
            //there is only one base case since we only move down and diagnolly so no chance to cross boundary or no chance of going in upper trianglar matrix

            // If already computed, return the stored value
            if (dp[i][j] != -1) return dp[i][j];

            // Compute the minimum path sum for the current cell
            int down = grid[i][j] + helper(i + 1, j, grid, dp);
            int diagonal = grid[i][j] + helper(i + 1, j + 1, grid, dp);

            // Store the result in dp array
            dp[i][j] = Math.min(down, diagonal);

            return dp[i][j];
        }


        //tabulation
        public static int helper2(int triangle[][],int dp[][],int n){
            for (int j = 0; j < n; j++) {
                dp[n - 1][j] = triangle[n - 1][j];
            }

            // Starting from the second to last row, calculate the minimum path sum for each element
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i; j >= 0; j--) {
                    // Calculate the two possible paths: moving down or moving diagonally
                    int down = triangle[i][j] + dp[i + 1][j];
                    int diagonal = triangle[i][j] + dp[i + 1][j + 1];

                    // Store the minimum of the two paths in dp
                    dp[i][j] = Math.min(down, diagonal);
                }
            }

            // The result is stored at the top of dp array
            return dp[0][0];
        }
    }

}
