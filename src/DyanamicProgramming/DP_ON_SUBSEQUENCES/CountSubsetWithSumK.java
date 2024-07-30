package DyanamicProgramming.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class CountSubsetWithSumK {

    //our approach
    class Solution {
        public static final int MOD = (int) 1e9 + 7;

        public int perfectSum(int[] arr, int n, int sum) {
            int[][] dp = new int[n][sum + 1];
            for (int[] rows : dp) {
                Arrays.fill(rows, -1);
            }
            return helper(n - 1, arr, sum, dp);
        }

        public static int helper(int index, int[] arr, int target, int[][] dp) {
            // Base case
            if (target == 0) return 1;
            if (index == 0) {
                return arr[0] == target ? 1 : 0;
            }

            // Memoization
            if (dp[index][target] != -1) return dp[index][target];

            // Explore all possibilities
            int notPick = helper(index - 1, arr, target, dp) % MOD;
            int pick = 0;

            if (arr[index] <= target) {
                pick = helper(index - 1, arr, target - arr[index], dp) % MOD;
            }

            // Return the summation of possibilities, taking modulo
            dp[index][target] = (pick + notPick) % MOD;
            return dp[index][target];
        }
    }


    //gfg approach
    class Solution2 {
        public static final int MOD = (int) 1e9 + 7;

        public int perfectSum(int[] arr, int n, int sum) {
            int[][] dp = new int[n + 1][sum + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            return fun(0,n, sum, arr,dp);
        }

        private int fun(int pos,int n, int sum, int[] arr,int dp[][]) {
            if (pos >= n) {
                return sum == 0 ? 1 : 0;
            }

            if (dp[pos][sum] != -1) {
                return dp[pos][sum];
            }



            //not pick
            int notpick = fun(pos + 1,n, sum, arr,dp)%MOD;

            int pick=0;
            //pick
            if (arr[pos] <= sum) {
                pick= fun(pos + 1, n,sum - arr[pos], arr,dp)%MOD;
            }

            return dp[pos][sum]=(pick+notpick)%MOD;
        }
    }
}
