package DyanamicProgramming;

import java.util.Arrays;

public class NinjaTraining {
    class Solution {
        public int maximumPoints(int points[][], int N) {
            // Initialize the dp array with -1
            int dp[][] = new int[N][4];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return MaxPoints(N - 1, 3, dp, points);
        }

        public static int MaxPoints(int day, int last, int dp[][], int points[][]) {
            if (day == 0) {
                int maxi = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        maxi = Math.max(maxi, points[0][task]);
                    }
                }
                return maxi;
            }

            if (dp[day][last] != -1) {
                return dp[day][last];
            }

            int maxi = 0;
            for (int task = 0; task < 3; task++) { // Removed the semicolon here
                if (task != last) {
                    int AccquiredPoints = points[day][task] + MaxPoints(day - 1, task, dp, points);
                    maxi = Math.max(maxi, AccquiredPoints);
                }
            }
            return dp[day][last] = maxi;
        }
    }

}
