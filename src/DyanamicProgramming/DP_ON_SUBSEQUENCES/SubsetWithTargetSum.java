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
            //return helper(N - 1, arr, sum, dp);
            return helper2(N, arr, sum);  //for tabulation
        }

        public static boolean helper(int index, int arr[], int target, Boolean dp[][]) {
            if (target == 0) return true; // If target is 0, subset is found

            if (index == 0) return arr[index] == target; // If index is negative, no subset can be found

            if (dp[index][target] != null) return dp[index][target]; // Return cached result

            boolean notPick = helper(index - 1, arr, target, dp); // Don't include the current element

            boolean pick = false;
            if (arr[index] <= target) { // Include the current element if it doesn't exceed target
                pick = helper(index - 1, arr, target - arr[index], dp);
            }

            dp[index][target] = notPick || pick; // Cache the result

            return dp[index][target];
        }

        public static boolean helper2(int n, int arr[], int k) {
            boolean dp[][] = new boolean[n][k + 1];

            // dp[index][target] this is our array
            // determine base cases
            // if (target == 0) we return true;
            for (int i = 0; i < arr.length; i++) {
                dp[i][0] = true;
            }

            // our base case in memoization is if (index == 0) we return true if arr[0] == target
            // here for every target we store true if index == 0
            // our final answer is on dp[n-1][target];
            if (arr[0] <= k) {
                dp[0][arr[0]] = true;
            }

            // write nested loops in bottom-up fashion
            // we start with 1 since 0 is already handled
            for (int index = 1; index < arr.length; index++) {
                for (int target = 1; target <= k; target++) { // Fixed the loop condition to target <= k
                    // copy the Recursive call and modify it
                    boolean notPick = dp[index - 1][target]; // Don't include the current element

                    boolean pick = false;
                    if (arr[index] <= target) { // Include the current element if it doesn't exceed target
                        pick = dp[index - 1][target - arr[index]];
                    }

                    dp[index][target] = notPick || pick;
                }
            }
            return dp[n - 1][k];
        }

    }
    }
