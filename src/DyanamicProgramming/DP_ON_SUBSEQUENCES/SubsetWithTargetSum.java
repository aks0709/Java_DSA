package DyanamicProgramming.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class SubsetWithTargetSum {
    class Solution {
        static Boolean isSubsetSum(int N, int arr[], int sum) {
            // Initialize the dp array to store boolean values
            Boolean dp[][] = new Boolean[N][sum + 1];
            for (Boolean[] row : dp) {
                Arrays.fill(row, null);
            }
            return helper(N - 1, arr, sum, dp);
        }

        public static boolean helper(int index, int arr[], int target, Boolean dp[][]) {
            if (target == 0) return true; // If target is 0, subset is found

            if (index == 0) return arr[index]==target; // If index is negative, no subset can be found

            if (dp[index][target] != null) return dp[index][target]; // Return cached result

            boolean notPick = helper(index - 1, arr, target, dp); // Don't include the current element

            boolean pick = false;
            if (arr[index] <= target) { // Include the current element if it doesn't exceed target
                pick = helper(index - 1, arr, target - arr[index], dp);
            }

            dp[index][target] = notPick || pick; // Cache the result

            return dp[index][target];
        }

    }
}
