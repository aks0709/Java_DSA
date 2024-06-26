package PP.RecursionDay_2;

import java.util.ArrayList;

public class SubsetsWithAtmost2 {
    public static void PrintSubSets(int arr[],int index,ArrayList<Integer> temp){
        if(index==arr.length)
        {
            System.out.println(temp);
            return;
        }
        PrintSubSets(arr,index+1,(ArrayList<Integer>) temp.clone()); //don't take
        temp.add(arr[index]);
        PrintSubSets(arr,index+1,(ArrayList<Integer>) temp.clone()); //take
        temp.add(arr[index]);
        PrintSubSets(arr,index+1,temp); // take atmost 2 times
    }
    public static void SubsetSum(ArrayList<Integer> arr,ArrayList<Integer> temp,int sum,int n){
       if(sum==0)
       {
           System.out.println(temp);
           return;
       }
       if(arr.size()==0)
           return;


    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        ArrayList<Integer> temp=new ArrayList<>();
        int n=arr.size();
       /* PrintSubSets(arr,0,temp);*/
        SubsetSum(arr,temp,5,n-1);
        temp.add(arr.get(n-1));
    }
}
