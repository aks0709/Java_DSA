package PP.Day5;

import java.util.ArrayList;

public class CountNoOfInversions
{
    public static int countInversion(int start,int end,int arr[]){
       int count=0;
       if(start>=end) return count;
        int mid=(start+end)/2;
        count=count+countInversion(start,mid,arr);
        count=count+countInversion(mid+1,end,arr);
        count=count+CountIAInversions(arr,start,mid,end);
        return count;
    }

    private static int CountIAInversions(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //Modification 1: cnt variable to count the pairs:
        int cnt = 0;

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); //Modification 2
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt; // Modification 3
    }

    public static void main(String[] args) {

    }
}
