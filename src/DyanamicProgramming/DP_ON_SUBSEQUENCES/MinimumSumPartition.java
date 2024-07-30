package DyanamicProgramming.DP_ON_SUBSEQUENCES;

import java.util.Arrays;

public class MinimumSumPartition {
    //GFG

    class Solution
    {

        public int minDifference(int arr[], int n)
        {
            // Your code goes here
            int TotalSum = 0;

            // Convert all elements to positive
            for (int i = 0; i < n; i++) {
                //nums[i] = Math.abs(nums[i]);
                TotalSum += arr[i];
            }

            boolean dp[][] = new boolean[n][TotalSum + 1];
            for (boolean[] rows : dp) {
                Arrays.fill(rows, false);
            }

            // dp[index][target] this is our array
            // determine base cases
            // if (target == 0) we return true;
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            // our base case in memoization is if (index == 0) we return true if arr[0] == target
            // our final answer is on dp[n-1][target];
            if (arr[0] <= TotalSum) {
                dp[0][arr[0]] = true;
            }

            // write nested loops in bottom-up fashion
            // we start with 1 since 0 is already handled
            for (int index = 1; index < n; index++) {
                for (int target = 1; target <= TotalSum; target++) { // Fixed the loop condition to target <= TotalSum
                    // copy the Recursive call and modify it
                    boolean notPick = dp[index - 1][target]; // Don't include the current element

                    boolean pick = false;
                    if (arr[index] <= target) { // Include the current element if it doesn't exceed target
                        pick = dp[index - 1][target - arr[index]];
                    }

                    dp[index][target] = notPick || pick;
                }
            }

            int mini = Integer.MAX_VALUE;
            for (int j = 0; j <= TotalSum ; j++) {
                if (dp[n - 1][j]) {
                    int s1 = j;
                    int s2 = TotalSum - j;
                    //if((Math.abs(s1)==Math.abs(s2))&&n==2) return s1+s2;

                    mini = Math.min(mini, Math.abs(s1 - s2));
                }
            }

            return mini;

        }
    }

}
