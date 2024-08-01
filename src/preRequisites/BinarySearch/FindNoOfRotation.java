package preRequisites.BinarySearch;

import java.util.List;

public class FindNoOfRotation {
//simply find minimum and returns its index
    class Solution {
        public int findKRotation(List<Integer> arr) {
            // Code here
            int low = 0, high = arr.size()-1;
            int ans = Integer.MAX_VALUE;
            while (low <= high) {
                int mid = (low + high) / 2;

                //search space is already sorted
                //then arr[low] will always be
                //the minimum in that search space:
                if (arr.get(low) <= arr.get(high)) {
                    ans = Math.min(ans, arr.get(low));
                    break;
                }

                //if left part is sorted:
                if (arr.get(low) <= arr.get(mid)) {
                    // keep the minimum:
                    ans = Math.min(ans, arr.get(low));

                    // Eliminate left half:
                    low = mid + 1;

                } else { //if right part is sorted:

                    // keep the minimum:
                    //it means the middle is the smallest in right half
                    ans = Math.min(ans, arr.get(mid));

                    // Eliminate right half:
                    high = mid - 1;
                }
            }
            int index=arr.indexOf(ans);
            return index;
        }
    }
}
