package PP.SortingDay5;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int arr1[]={2,2,3,11,20,25};
        int arr2[]={1,4,4,7,13,19};
        int res[]=new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while (i<arr1.length&&j<arr2.length){
            if(arr1[i]<arr2[j])
            {
                res[k]=arr1[i];
                i++;
            }
            else
            {
                res[k]=arr2[j];
                j++;
            }
            k++;
        }
        while(i<arr1.length){
            res[k]= arr1[i];
            i++;
            k++;
        }
        while(j<arr2.length){
            res[k]=arr2[j];
            j++;
            k++;
        }
        //T.C O(M+N)
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(res));
    }
}
