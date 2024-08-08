package DyanamicProgramming.DP_ON_STRINGS;

import java.util.Arrays;

public class DistinctSubSequences {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        return helper(s.length()-1,t.length()-1,s,t,dp);

    }
    public static int helper(int index1,int index2,String s,String t,int dp[][]){
        //base case
        if(index2<0) return 1;
        if(index1<0) return 0;
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        // If the characters at the current positions match, we can either leave one character from s1
        // or continue to the next character in s1 while staying at the same character in s2.
        if (s.charAt(index1) == t.charAt(index2)) {
            int leaveOne = helper(index1 - 1, index2 - 1, s, t,dp);
            int stay = helper(index1 - 1, index2,s, t, dp);

            // Add the two possibilities and take modulo prime to avoid integer overflow.
            return dp[index1][index2] = (leaveOne + stay);
        } else {
            // If the characters don't match, we can only continue to the next character in s1.
            return dp[index1][index2] = helper(index1 - 1, index2,s, t, dp);
        }
    }
}
