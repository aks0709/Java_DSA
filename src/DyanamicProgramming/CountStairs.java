package DyanamicProgramming;


import java.util.Arrays;

public class CountStairs {
        public static int solve(int n,int dp[]){
            if(n==0) return 1;
            if(n==1) return 1;

            if(dp[n]!=-1)  return dp[n];

            return dp[n]=solve(n-1,dp)+solve(n-2,dp);

        }
        public int climbStairs(int n) {
            int dp[]=new int[n+1];
            Arrays.fill(dp,-1);
            return solve(n,dp);
        }
    public static void main(String[] args) {

    }
}