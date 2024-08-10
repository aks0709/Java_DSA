package DyanamicProgramming.DP_ON_STRINGS;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()][word2.length()];
        for(int rows[] : dp)
            Arrays.fill(rows,-1);

        return helper(word1.length()-1,word2.length()-1,word1,word2,dp);
    }
    public static int helper(int ind1,int ind2,String word1,String word2,int dp[][]){
        //base case
        if(ind1<0) return ind2+1;
        if(ind2<0) return ind1+1;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        //if match
        if(word1.charAt(ind1)==word2.charAt(ind2))
            return dp[ind1][ind2]=0+helper(ind1-1,ind2-1,word1,word2,dp);
        else
            return dp[ind1][ind2]=1+Math.min(helper(ind1,ind2-1,word1,word2,dp),Math.min(helper(ind1-1,ind2,word1,word2,dp),helper(ind1-1,ind2-1,word1,word2,dp)));
    }
}
