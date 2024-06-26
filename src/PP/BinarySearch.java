package PP;

public class BinarySearch {
    public  int binarySearch(int arr[],int target){
        int start=0;
        int end=arr.length-1;
        while (start<=end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    //first occurence of target
    public static int binarySearch1(int arr[],int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end) {
            int mid=(start+end)/2;
            if (arr[mid] == target) {
                if (mid == 0) return mid;

                if (arr[mid - 1] != target) return mid;
                else
                    end = mid - 1;
            }
            if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
    //last occurence of target
    public static int binarySearch2(int arr[],int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                if (mid == arr.length - 1) return mid;

                if (arr[mid + 1] != target) return mid;
                else
                    end = mid + 1;
            }
            if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={1,4,4,4,4,5,7,9,13};
        System.out.println(binarySearch1(arr,4));
        System.out.println(binarySearch2(arr,4));
    }
}
