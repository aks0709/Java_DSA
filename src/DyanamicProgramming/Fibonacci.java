package DyanamicProgramming;

import java.util.Arrays;

public class Fibonacci {
   //recursive code
    public static int fib(int n){
        if(n<=1)
            return n;

        return fib(n-1)+fib(n-2);
    }
    //using dp(Memoization)
    public static int fib2(int n,int dp[]){
        if(n<=1)
            return n;

        if(dp[n]!=-1)  return dp[n];   //step 2 check if dp[n] is computed or not ,-1 shows not computed
        return dp[n]=fib(n-1)+fib(n-2);  //step 1 store the cmputed value in dp array  and return
    }
    //using DP(TABULATION)
    public static int fib3(int n,int dp[]){
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    //more optimised
    public static int fib4(int n){
        int prev2=0;
        int prev=1;
        //int curr=prev+prev2;
        for(int i=2;i<=n;i++){
           int curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }

        return prev;
    }

    public static void main(String[] args) {
        int n=5;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fib2(n,dp));
        System.out.println(fib3(n,dp));
        System.out.println(fib4(n));
    }
}
