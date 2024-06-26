package PP.Day5;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortCodeForces {
    public static void mergesort(int arr[],int low ,int high,int k){
        if(low>=high-1)  return;
        if(k==0) return;

        int mid=(low+high)/2;
        int p=mid;
        swap(arr,p,p+1);
        k=k-2;
        mergesort(arr,low,mid,k);
        mergesort(arr,mid+1,high,k);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int n;
        int k;
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
        k= sc.nextInt();
        if(k%2==0||k>2*(n-1))
            System.out.println(-1);
        else{
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=i+1;
            }
            k=k-1;
            System.out.println(Arrays.toString(arr));
            mergesort(arr,0,n-1,k);
            System.out.println(Arrays.toString(arr));
        }
    }

}
