package DyanamicProgramming;

import java.util.Arrays;

public class House_Robber_2 {
    class Solution {

        public static int MaxSum(int index, int arr[], int dp[]) {
            if (index == 0) return arr[index];
            if (index < 0) return 0;
            if (dp[index] != -1) return dp[index];

            int pick = arr[index] + MaxSum(index - 2, arr, dp);
            int notPick = 0 + MaxSum(index - 1, arr, dp);

            return dp[index] = Math.max(pick, notPick);
        }

        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];
            // the logic is same as house rober1/maximum non adjacent sum
            int dp1[] = new int[n];
            int dp2[] = new int[n];
            Arrays.fill(dp1, -1);
            Arrays.fill(dp2, -1);

            //array 1 where we left first element
            int temp1[] = new int[n - 1];
            for (int i = 1; i < n; i++) {
                temp1[i - 1] = nums[i];
            }

            //array 2 where we left last element
            int temp2[] = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                temp2[i] = nums[i];
            }

            //we created two array becoz it is stated that first and last are connected

            int res1 = MaxSum(n - 2, temp1, dp1);
            int res2 = MaxSum(n - 2, temp2, dp2);
            return Math.max(res1, res2);
        }
    }

}
