package DyanamicProgramming;

import java.util.Arrays;

public class FrogJump {
    public static int solve(int index,int dp[],int arr[]){
        if(index==0) return 0;

        if(dp[index]!=-1) return dp[index];

        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne= solve(index-1,dp,arr)+ Math.abs(arr[index]-arr[index-1]);
        if(index>1)
            jumpTwo = solve(index-2,dp,arr)+ Math.abs(arr[index]-arr[index-2]);

        return dp[index]=Math.min(jumpOne, jumpTwo);
    }
    public static int frogJump(int n, int heights[]) {

        // Write your code here..

        int dp[]=new int[heights.length];
        Arrays.fill(dp,-1);
        int res=solve(n-1,dp,heights);
        return res;
    }


    //tabulation

    public static int frogJump2(int n, int arr[]) {

        // Write your code here..

        int dp[]=new int[arr.length];
        Arrays.fill(dp,0);
        dp[0]=0;
        for(int i=1;i<n;i++){

            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne=dp[i-1]+ Math.abs(arr[i]-arr[i-1]);
            if(i>1)
                jumpTwo =dp[i-2]+ Math.abs(arr[i]-arr[i-2]);

            dp[i]=Math.min(jumpOne,jumpTwo);
        }

        return dp[n-1];

    }
    public static void main(String[] args) {

    }
}
