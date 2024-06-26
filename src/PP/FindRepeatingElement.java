package PP;

public class FindRepeatingElement
{

    //brute force
    //1) find sum
    //2) Using Map


    //optimised
    public static int BS(int arr[]){
        int low=0;
        int high=arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            int count=mid+1;
            if(count>arr[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,5};
        System.out.println(BS(arr));
    }
}
