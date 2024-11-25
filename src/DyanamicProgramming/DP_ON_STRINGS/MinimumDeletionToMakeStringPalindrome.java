package DyanamicProgramming.DP_ON_STRINGS;

import java.util.Arrays;

public class MinimumDeletionToMakeStringPalindrome {
    class Solution {
        public static int lcs(int index1, int index2, String s1, String s2, int dp[][]) {
            // Base case: If either index goes out of bounds, return 0
            if (index1 < 0 || index2 < 0) return 0;

            // Memoization: Check if this subproblem has already been solved
            if (dp[index1][index2] != -1) return dp[index1][index2];

            // If characters match, add 1 to the result of the subproblem
            if (s1.charAt(index1) == s2.charAt(index2)) {
                dp[index1][index2] = 1 + lcs(index1 - 1, index2 - 1, s1, s2, dp);
            } else {
                // Otherwise, take the max of skipping one character from either string
                dp[index1][index2] = Math.max(lcs(index1 - 1, index2, s1, s2, dp),
                        lcs(index1, index2 - 1, s1, s2, dp));
            }

            return dp[index1][index2];
        }

        static int minimumNumberOfDeletions(String S) {
            int n = S.length();
            StringBuilder sb = new StringBuilder(S);
            sb.reverse(); // Reverse the string to compare with the original

            // Create a dp array to store the lengths of LCS for subproblems
            int[][] dp = new int[n][n];
            for (int[] row : dp) {
                Arrays.fill(row, -1); // Initialize dp array with -1 to represent uncalculated states
            }

            // Calculate the length of the longest common subsequence between S and its reverse
            int lcsLength = lcs(n - 1, n - 1, S, sb.toString(), dp);

            // The minimum number of deletions is the difference between the string length and the LCS length
            return n - lcsLength;
        }
    }

    public static void main(String[] args) {
        System.out.println("HELP");
    }
}
