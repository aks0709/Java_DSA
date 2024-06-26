package PP.SortingDay5;

import java.util.Arrays;

public class SortSqaures {
    public static void main(String[] args) {
        int arr[]={-15,-3,-1,0,3,6,9,11,100};
        int p=0;
        for(int i=0;i<arr.length;i++) {
            if (arr[i] >= 0) {
                p = i;
                break;
            }
        }
        int i=p;
        int j=p-1;
        int k=0;
        int res[]=new int[arr.length];
        while(i< arr.length&&j>=0){
            if(arr[j]*arr[j]<arr[i]*arr[i])
            {
                res[k]=arr[j];
                k++;
                j--;
            }
            else {
                if(arr[j]*arr[j]==arr[i]*arr[i]){
                    if(arr[j]<arr[i])
                    {
                        res[k]=arr[j];
                        j--;
                        k++;
                    }
                    else{
                        res[k]=arr[i];
                        i++;
                        k++;
                    }
                }
                else {
                    res[k] = arr[i];
                    i++;
                    k++;
                }
            }
        }
        while (i< arr.length){
            res[k]=arr[i];
            i++;
            k++;
        }
        while(j>=0){
            res[k]=arr[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(res));

        //handle test cases //edges cases
    }
}
