package DyanamicProgramming.DP_ON_STRINGS;

public class ShortestCommonSuperSequence {
    class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {
            int n = str1.length();
            int m = str2.length();

            // Create a 2D array to store results of subproblems
            int[][] dp = new int[n + 1][m + 1];

            // Initialize the dp array
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 0;
            }
            for (int i = 0; i <= m; i++) {
                dp[0][i] = 0;
            }

            // Fill the dp array using dynamic programming
            for (int ind1 = 1; ind1 <= n; ind1++) {
                for (int ind2 = 1; ind2 <= m; ind2++) {
                    if (str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1)) {
                        dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    } else {
                        dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                    }
                }
            }


            //printing using DP table : Must refer Printing LCS ,
            //catch is you to append character to the sting as you are moving
            // Initialize a StringBuilder to construct the supersequence
            StringBuilder sb = new StringBuilder();
            int i = n, j = m;
            while (i > 0 && j > 0) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    sb.append(str1.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i][j - 1] >= dp[i - 1][j]) {
                    sb.append(str2.charAt(j - 1));
                    j--;
                } else {
                    sb.append(str1.charAt(i - 1));
                    i--;
                }
            }

            // Add remaining characters of str1
            while (i > 0) {
                sb.append(str1.charAt(i - 1));
                i--;
            }

            // Add remaining characters of str2
            while (j > 0) {
                sb.append(str2.charAt(j - 1));
                j--;
            }

            // Return the reverse of the StringBuilder's content
            return sb.reverse().toString();
        }
    }

}
