package DyanamicProgramming;

import java.util.Arrays;

public class EditDistance2DP {
    class Solution {
        public int getED(int i,int j,String word1,String word2,int DP[][]){
            if(i==-1)
                return j+1;   //length of word 2
            if(j==-1)
                return i+1;  //length of word 1
            if(DP[i][j]!=-1)  return DP[i][j];
            if(word1.charAt(i)==word2.charAt(j))
                return DP[i][j]=getED(i-1,j-1,word1,word2,DP);
            else
                return DP[i][j]=1+Math.min(getED(i-1,j-1,word1,word2,DP),Math.min(getED(i,j-1,word1,word2,DP),getED(i-1,j,word1,word2,DP)));
        }
        public int minDistance(String word1, String word2) {
            int DP[][]=new int[word1.length()][word2.length()];
            for(int row[]:DP)
                Arrays.fill(row,-1);
            return getED(word1.length()-1,word2.length()-1,word1,word2,DP);
        }
    }
}
