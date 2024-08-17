package DyanamicProgramming.DP_ON_STOCKS;

import java.util.Arrays;

public class BuyAndSellStock4 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            int[][][] dp = new int[n][2][k + 1];

            // Initialize the dp array with -1
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }

            return helper(0, 1, k, prices, dp);
        }

        public static int helper(int index, int buy, int count, int[] prices, int[][][] dp) {
            // Base cases
            if (index == prices.length || count == 0) {
                return 0;
            }

            // Return memoized result
            if (dp[index][buy][count] != -1) {
                return dp[index][buy][count];
            }

            int profit = 0;

            if (buy == 1) { // Buy or skip
                profit = Math.max(
                        -prices[index] + helper(index + 1, 0, count, prices, dp), // Buy stock
                        helper(index + 1, 1, count, prices, dp) // Skip
                );
            } else { // Sell or skip
                profit = Math.max(
                        prices[index] + helper(index + 1, 1, count - 1, prices, dp), // Sell stock
                        helper(index + 1, 0, count, prices, dp) // Skip
                );
            }

            // Store and return the result
            return dp[index][buy][count] = profit;
        }
    }

}
