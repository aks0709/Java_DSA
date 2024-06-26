package PP.BackTrackingDay4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratePermutation {
    public static void GP(char[] arr,int index){
        if(index>= arr.length){
            for(int i=0;i< arr.length;i++)
                System.out.print(arr[i]);
            System.out.println();
                 return;
        }
        else {
            for(int i=index;i<arr.length;i++){
                swap(arr,i,index);  //swap
                GP(arr,index+1);
                swap(arr,i,index);  //Un swap
            }
        }
    }

    //generate permutation in Lexiographic order
    //either we store all permutation in list and sort the lost
   /* public static void GP2(char[] arr,int index,ArrayList<> list){
        if(index>= arr.size()){
            list.add(arr);
            return;
        }
        else {
            for(int i=index;i<arr.size();i++){
              Collections.swap(arr,i,index);  //swap
                GP2(arr,index+1,list);
                Collections.swap(arr,i,index);  //Un swap
            }
        }
    }*/
    public static void swap(char arr[],int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        char arr[]={'a','b','c'};
        GP(arr,0);
       /* ArrayList<Character> arr2=new ArrayList<>();*/
        /*arr2.add('a');
        arr2.add('b');
        arr2.add('c');
        ArrayList<ArrayList<Character>> list=new ArrayList<>();
        */
       /* GP2(arr2,0,arr2);
        Collections.sort(arr2);
*/
    }
}
