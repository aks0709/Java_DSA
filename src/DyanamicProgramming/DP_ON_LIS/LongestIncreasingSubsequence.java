package DyanamicProgramming.DP_ON_LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            //since prev can be -1 so we need to do index shift ,coordinate change
            int n=nums.length;
            int dp[][]=new int[n][n+1];
            for(int rows[] : dp)
                Arrays.fill(rows,-1);

            return helper(0,-1,nums,dp);
        }
        public static int helper(int index,int prev,int nums[],int dp[][]){
            //base case
            if(index==nums.length) return 0;

            if(dp[index][prev+1]!=-1) return dp[index][prev+1];
            //pick vs not pick
            int notpick=0+helper(index+1,prev,nums,dp); //no increase in length,prev does not change
            int pick=0;
            if(prev==-1 || nums[index]>nums[prev])
                pick=1+helper(index+1,index,nums,dp);  //prev will become index

            return dp[index][prev+1]=Math.max(pick,notpick);
        }
    }
}
