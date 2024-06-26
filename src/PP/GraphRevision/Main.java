package PP.GraphRevision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    //static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int fee= sc.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++)
            arr[i]= sc.nextInt();
        int max=0;
        int min=arr[0];
        for(int i=1;i<N;i++){
            if(arr[i]<min)
                min=arr[i];
            else if (arr[i] - min - fee > 0) {
                max += arr[i] - min - fee;
                min = arr[i] - fee;
            }

        }
        System.out.println(max);
    }
}
