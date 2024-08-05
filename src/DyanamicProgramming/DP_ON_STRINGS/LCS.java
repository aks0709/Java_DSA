package DyanamicProgramming.DP_ON_STRINGS;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {

    }
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()][text2.length()];
        for(int rows[]:dp)
            Arrays.fill(rows,-1);

        return helper(text1.length()-1,text2.length()-1,text1,text2,dp);
    }
    public static int helper(int index1,int index2,String text1,String text2,int dp[][]){
        if(index1<0 || index2<0) return 0;

        if(dp[index1][index2]!=-1) return dp[index1][index2];

        if(text1.charAt(index1)==text2.charAt(index2))//match
            return dp[index1][index2]=1+helper(index1-1,index2-1,text1,text2,dp);

        //not match
        return dp[index1][index2]=0+Math.max(helper(index1-1,index2,text1,text2,dp),helper(index1,index2-1,text1,text2,dp));
    }
    //tabulation
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Initialize the first row and first column with zeros since LCS with an empty string is zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using dynamic programming
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If the characters at the current indices are the same, increment the LCS length
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    // If the characters are different, choose the maximum LCS length by either
                    // excluding a character in s1 or excluding a character in s2
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m]; // Return the length of the Longest Common Subsequence (LCS)
    }

}
