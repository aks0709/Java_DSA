package DyanamicProgramming.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class CountSubsetWithSumK {
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
            // if (target == 0) return 1;  this will cause problem
            //suppose [0,0,1]  and our target is 1 and we start from back in that case
            //{0,0,1}  {0,1}  {1}  these are possible subsets
            //but according to base case we return as target==0

            if (index == 0) {

                if(target==0 && arr[0]==0) return 2;
                return arr[0] == target || target==0 ? 1 : 0;
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


}
