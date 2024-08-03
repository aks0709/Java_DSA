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
}
