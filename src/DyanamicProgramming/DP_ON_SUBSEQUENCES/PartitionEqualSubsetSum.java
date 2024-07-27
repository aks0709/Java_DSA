package DyanamicProgramming.DP_ON_SUBSEQUENCES;
import java.util.*;
public class PartitionEqualSubsetSum {
    class Solution {
        public boolean canPartition(int[] nums) {
            int totSum=0;
            for(int i=0;i<nums.length;i++) totSum+=nums[i];
            if(totSum%2!=0)  return false;


            Boolean dp[][] = new Boolean[nums.length][(totSum/2) + 1];
            for (Boolean[] row : dp) {
                Arrays.fill(row, null);
            }

            return helper(nums.length - 1, nums, totSum/2, dp);
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
