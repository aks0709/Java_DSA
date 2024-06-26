package PP;

import java.util.Scanner;

public class PrefixSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={1,2,3,4,5,6};
        int PA[]=new int[arr.length];
        PA[0] = arr[0];
        // Adding present element with previous element
        for (int i = 1; i < arr.length; ++i)
            PA[i] = PA[i - 1] + arr[i];
        int Q=sc.nextInt();  //no of Queries
        while(Q>0) {
            int l=sc.nextInt();
            int r= sc.nextInt();
            int res=0;
            if(l==0)
                res=PA[r];
            else {
                res = PA[r] - PA[l - 1];
            }
            System.out.println(res);
            Q--;
        }
    }
}
