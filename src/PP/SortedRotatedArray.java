package PP;

public class SortedRotatedArray
{
    public  int binarySearch(int arr[],int target){
        int start=0;
        int end=arr.length-1;
        while (start<=end) {
            int mid = (start + end) / 2;
            if (arr[mid] <=arr[mid-1])
                 end=mid-1;
            else
            {
                if(arr[mid]>arr[mid+1])  //we find pivot
                    return mid;
                else
                    end=mid+1;
            }

            if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
