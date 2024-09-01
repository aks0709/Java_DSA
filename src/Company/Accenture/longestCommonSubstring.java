package Company.Accenture;

public class longestCommonSubstring {
    public static void main(String[] args) {
        String str1 = "adventure";
        String str2 = "future";
        int[] result = lcslen(str1, str2);
        int maxLength = result[0];
        int endIndex = result[1];
        String res = str1.substring(endIndex - maxLength + 1, endIndex + 1);
        System.out.println(res);  // Output should be "ture"
        int ans=0;
        for(char ch : res.toCharArray()){
            ans+=ch;
        }
        System.out.println(ans);
    }

    public static int[] lcslen(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        int maxLen = 0;
        int endIndex = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return new int[]{maxLen, endIndex};
    }
}
