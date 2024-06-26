package PP.BackTrackingDay4;

class Solution {
    public static int count(int index,int arr[]){
        if(index>=arr.length)
            return 1;

        int ans=0;
        for(int i=index;i<arr.length;i++){
            if(arr[i]%(index+1)==0||(index+1)%arr[i]==0)
            {
                swap(arr,i,index);
                ans=ans+count(index+1,arr);
                swap(arr,i,index);
            }
        }
        return ans;
    }

    public static void swap(int arr[],int i ,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int countArrangement(int n) {
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        int res=count(0,arr);
        return res;
    }
}
public class BeautifulPermutation
{
}
