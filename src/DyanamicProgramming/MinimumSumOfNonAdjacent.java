package DyanamicProgramming;

import java.util.Arrays;

public class MinimumSumOfNonAdjacent {
    public static int MaxSum(int index,int arr[],int dp[]){
        if(index==0) return arr[index];

        if(index<0)  return 0;
        if(dp[index]!=-1) return dp[index];
        int pick=arr[index]+MaxSum(index-2,arr,dp);
        int notPick=0+MaxSum(index-1,arr,dp);

        return dp[index]=Math.max(pick,notPick);
    }
    public static void main(String[] args) {
        int arr[]=new int[7];
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int res=MaxSum(n-1,arr,dp);
    }
}
