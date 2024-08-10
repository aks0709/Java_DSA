package DyanamicProgramming.DP_ON_STRINGS;

public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return helper(s.length(), p.length(), s, p, dp);
    }

    private boolean helper(int i, int j, String s, String p, Boolean[][] dp) {
        // Base cases
        if (i == 0 && j == 0) return true;  // Both strings are exhausted
        if (j == 0) return false;           // Pattern is exhausted, string is not
        if (i == 0) {                       // String is exhausted, check if remaining pattern can match
            for (int k = 0; k < j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        // Check if already computed
        if (dp[i][j] != null) return dp[i][j];

        // Match or wildcard cases
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?' || s.charAt(i - 1) == '?') {
            dp[i][j] = helper(i - 1, j - 1, s, p, dp);
        } else if (p.charAt(j - 1) == '*' || s.charAt(i - 1) == '*') {
            dp[i][j] = helper(i - 1, j, s, p, dp) || helper(i, j - 1, s, p, dp);
        } else {
            dp[i][j] = false;
        }

        return dp[i][j];
    }
}
